package fr.upec.sirius.episaine.episaine_generate_notification.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.KafkaEventResponse;
import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.Notification;
import fr.upec.sirius.episaine.episaine_generate_notification.kafka.consumer.NotificationsConsumer;
import fr.upec.sirius.episaine.episaine_generate_notification.kafka.producer.NotificationsProducer;
import fr.upec.sirius.episaine.episaine_generate_notification.redis.RedisNotificationRead;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
@Slf4j
public class CustomerController {
    private final RedisNotificationRead redisNotificationRead;
    private final NotificationsConsumer notificationsConsumer;
    private final NotificationsProducer notificationsProducer;

    @GetMapping("/cache")
    public List<Notification> getNotificationsFromCache() {
        log.info("GET /notifications/cache called");
        return redisNotificationRead.getNotificationStateFromCache();
    }

    @GetMapping("/kafka")
    public List<KafkaEventResponse> getKafkaEvents() {
        log.info("GET /notifications/kafka called");
        return notificationsConsumer.consumeAll();
    }

    @PostMapping("/generate")
    public String generateNotifications() {
        log.info("POST /notifications/generate called");
        notificationsProducer.generateNotifications();
        return "Notifications generated successfully";
    }

    @PostMapping("/generate/{customerId}")
    public String forceNotification(@PathVariable int customerId) {
        log.info("POST /notifications/generate/{} called", customerId);
        boolean sent = notificationsProducer.forceNotificationForCustomer(customerId);
        return sent
                ? "Notification forced for customer " + customerId
                : "No matching recipes for customer " + customerId;
    }
    
}
