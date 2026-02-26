package fr.upec.sirius.episaine.episaine_send_notification.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.upec.sirius.episaine.episaine_send_notification.dto.NotificationBatchDto;
import fr.upec.sirius.episaine.episaine_send_notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final NotificationService notificationService;

    @Value("${app.kafka.notifications-to-send-topic:notifications-to-send}")
    private String notificationsToSendTopic;

    @KafkaListener(topics = "${app.kafka.notifications-to-send-topic:notifications-to-send}", groupId = "${spring.kafka.consumer.group-id:send-notifications-group}")
    public void consume(String payload) {
        try {
            NotificationBatchDto batch = MAPPER.readValue(payload, NotificationBatchDto.class);
            log.info("Received notification for customer {} with {} recipes from topic {}",
                    batch.getCustomerId(), batch.getRecipesId().size(), notificationsToSendTopic);
            notificationService.processNotification(batch);
        } catch (Exception e) {
            log.error("Error processing notification payload: {}", payload, e);
            throw new IllegalStateException("Notification processing failed", e);
        }
    }
}
