package fr.upec.sirius.episaine.episaine_send_notification.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.upec.sirius.episaine.episaine_send_notification.dto.NotificationBatchDto;
import fr.upec.sirius.episaine.episaine_send_notification.dto.NotificationSentEventDto;
import fr.upec.sirius.episaine.episaine_send_notification.dto.RecipeDto;
import fr.upec.sirius.episaine.episaine_send_notification.entity.InAppNotification;
import fr.upec.sirius.episaine.episaine_send_notification.repository.CustomerNotificationStateRepository;
import fr.upec.sirius.episaine.episaine_send_notification.repository.NotificationRepository;
import fr.upec.sirius.episaine.episaine_send_notification.repository.RecipeReadRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private static final String ACTIVE_CUSTOMERS_KEY = "customers:active:";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final NotificationRepository notificationRepository;
    private final RecipeReadRepository recipeReadRepository;
    private final CustomerNotificationStateRepository customerNotificationStateRepository;
    private final RedisTemplate<String, Object> redisTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka.notifications-sent-topic:notifications-sent}")
    private String notificationsSentTopic;

    @Transactional
    public void processNotification(NotificationBatchDto batch) {
        validateBatch(batch);

        InAppNotification notification = InAppNotification.builder()
                .customerId(batch.getCustomerId())
                .title("New recipes!")
                .message(batch.getRecipesId().size() + " new recipes added to your collection.")
                .recipeIds(new LinkedHashSet<>(batch.getRecipesId()))
                .isRead(false)
                .build();

        InAppNotification saved = notificationRepository.save(notification);
        log.info("Notification saved with id {} for customer {}", saved.getId(), saved.getCustomerId());

        LocalDateTime sentAt = LocalDateTime.now();
        publishNotificationSentEvent(batch.getCustomerId(), batch.getRecipesId());
        updateNotificationStateInPsql(batch.getCustomerId(), sentAt);
        updateNotificationStateInRedis(batch.getCustomerId(), sentAt);
    }

    public List<RecipeDto> getRecipesByCustomerId(Integer customerId) {
        List<InAppNotification> notifications = notificationRepository.findByCustomerId(customerId);
        if (notifications.isEmpty()) {
            return List.of();
        }

        Set<Integer> recipeIds = notifications.stream()
                .map(InAppNotification::getRecipeIds)
                .filter(Objects::nonNull)
                .flatMap(Set::stream)
                .collect(LinkedHashSet::new, Set::add, Set::addAll);

        if (recipeIds.isEmpty()) {
            return List.of();
        }

        Map<Integer, RecipeDto> recipesById = recipeReadRepository.findByIds(new ArrayList<>(recipeIds)).stream()
                .collect(java.util.stream.Collectors.toMap(RecipeDto::getId, recipe -> recipe));

        List<RecipeDto> orderedRecipes = new ArrayList<>();
        for (Integer recipeId : recipeIds) {
            RecipeDto recipe = recipesById.get(recipeId);
            if (recipe != null) {
                orderedRecipes.add(recipe);
            }
        }
        return orderedRecipes;
    }

    public List<InAppNotification> getNotifications(Integer customerId) {
        return notificationRepository.findByCustomerId(customerId);
    }

    @Transactional
    public void markAsRead(Long notificationId) {
        notificationRepository.markAsRead(notificationId);
    }

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void cleanup() {
        int deleted = notificationRepository.deleteExpired(LocalDateTime.now());
        log.info("Cleaned {} expired notifications", deleted);
    }

    private void publishNotificationSentEvent(Integer customerId, List<Integer> recipesId) {
        NotificationSentEventDto event = NotificationSentEventDto.builder()
                .customerId(customerId)
                .recipesId(recipesId)
                .build();

        try {
            String payload = MAPPER.writeValueAsString(event);
            kafkaTemplate.send(notificationsSentTopic, String.valueOf(customerId), payload).get(10, TimeUnit.SECONDS);
            log.info("Published sent notification event for customer {} to {}", customerId, notificationsSentTopic);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Failed to serialize sent notification event", e);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to publish sent notification event", e);
        }
    }

    private void updateNotificationStateInPsql(Integer customerId, LocalDateTime sentAt) {
        int updatedRows = customerNotificationStateRepository.updateLastNotification(customerId, sentAt);
        if (updatedRows == 0) {
            log.warn("No customer row updated for customer_id={}", customerId);
        }
    }

    private void updateNotificationStateInRedis(Integer customerId, LocalDateTime sentAt) {
        long epochSeconds = sentAt.toEpochSecond(ZoneOffset.UTC);
        String key = ACTIVE_CUSTOMERS_KEY + customerId;
        try {
            redisTemplate.opsForValue().set(key, sentAt + ":" + epochSeconds);
        } catch (Exception e) {
            log.warn("Redis update failed for customer_id={} (continuing without Redis sync): {}", customerId, e.getMessage());
        }
    }

    private void validateBatch(NotificationBatchDto batch) {
        if (batch == null || batch.getCustomerId() == null) {
            throw new IllegalArgumentException("Invalid notification payload: missing customer_id");
        }
        if (batch.getRecipesId() == null || batch.getRecipesId().isEmpty()) {
            throw new IllegalArgumentException("Invalid notification payload: recipes_id is empty");
        }
    }
}
