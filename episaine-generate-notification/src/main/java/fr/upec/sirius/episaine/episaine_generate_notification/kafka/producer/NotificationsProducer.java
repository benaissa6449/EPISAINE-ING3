package fr.upec.sirius.episaine.episaine_generate_notification.kafka.producer;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.KafkaEventResponse;
import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.Notification;
import fr.upec.sirius.episaine.episaine_generate_notification.data.model.Recipe;
import fr.upec.sirius.episaine.episaine_generate_notification.kafka.consumer.NotificationsConsumer;
import fr.upec.sirius.episaine.episaine_generate_notification.redis.RedisNotificationRead;
import fr.upec.sirius.episaine.episaine_generate_notification.service.RecipeService;
import fr.upec.sirius.episaine.episaine_generate_notification.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationsProducer {

    private static final String TOPIC = "notifications-to-send";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final RedisNotificationRead redisNotificationRead;
    private final RecipeService recipeService;
    private final NotificationsConsumer notificationsConsumer;

    public void generateNotifications() {
        List<Notification> cachedCustomers = redisNotificationRead.getNotificationStateFromCache();
        log.info("{} active customers retrieved from Redis", cachedCustomers.size());

        List<KafkaEventResponse> kafkaEvents = notificationsConsumer.consumeAll();
        log.info("{} kafka events retrieved", kafkaEvents.size());

        int notified = 0;
        for (Notification notification : cachedCustomers) {
            int customerId = notification.getCustomer_id();
            if (notification.getLastNotification() != null
                    && Utils.hasbeen24h(notification.getLastNotification().getTime() / 1000)) {
                log.debug("Customer {} already notified in the last 24h, skipping", customerId);
                continue;
            }

            List<Recipe> recipes = recipeService.getRecipesForCustomer(customerId, kafkaEvents);
            if (recipes.isEmpty()) {
                log.info("No matching recipes for customer {}, skipping", customerId);
                continue;
            }

            KafkaEventResponse event = new KafkaEventResponse();
            event.setCustomer_id(customerId);
            event.setRecipes_id(recipes.stream().map(Recipe::getRecipe_id).toList());
            sendNotification(event);
            notified++;
        }

        log.info("Notifications generated: {}/{} customers", notified, cachedCustomers.size());
    }

    public boolean forceNotificationForCustomer(int customerId) {
        List<KafkaEventResponse> kafkaEvents = notificationsConsumer.consumeAll();

        List<Recipe> recipes = recipeService.getRecipesForCustomer(customerId, kafkaEvents);
        if (recipes.isEmpty()) {
            log.info("No matching recipes for customer {}, nothing to send", customerId);
            return false;
        }

        KafkaEventResponse event = new KafkaEventResponse();
        event.setCustomer_id(customerId);
        event.setRecipes_id(recipes.stream().map(Recipe::getRecipe_id).toList());
        sendNotification(event);
        log.info("Forced notification for customer {} with {} recipes", customerId, recipes.size());
        return true;
    }

    private void sendNotification(KafkaEventResponse event) {
        try {
            String json = MAPPER.writeValueAsString(event);
            kafkaTemplate.send(TOPIC, String.valueOf(event.getCustomer_id()), json);
            log.info("Published notification for customer {} with {} recipes to topic {}",
                    event.getCustomer_id(), event.getRecipes_id().size(), TOPIC);
        } catch (JsonProcessingException e) {
            log.error("Failed to serialize notification for customer {}: {}",
                    event.getCustomer_id(), e.getMessage());
        }
    }
}
