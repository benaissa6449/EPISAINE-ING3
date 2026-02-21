package fr.upec.sirius.episaine.episaine_generate_notification.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.KafkaEventResponse;
import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.Notification;
import fr.upec.sirius.episaine.episaine_generate_notification.kafka.consumer.NotificationsConsumer;
import fr.upec.sirius.episaine.episaine_generate_notification.kafka.producer.NotificationsProducer;
import fr.upec.sirius.episaine.episaine_generate_notification.redis.RedisNotificationRead;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/notifications")
@AllArgsConstructor
public class CustomerController {
    private final RedisNotificationRead redisNotificationRead;
    private final NotificationsConsumer notificationsConsumer;
    private final NotificationsProducer notificationsProducer;

    @GetMapping("/cache")
    public List<Notification> getNotificationsFromCache() {
        return redisNotificationRead.getNotificationStateFromCache();
    }

    @GetMapping("/kafka")
    public List<KafkaEventResponse> getKafkaEvents() {
        return notificationsConsumer.consumeAll();
    }

    @PostMapping("/generate")
    public String generateNotifications() {
        notificationsProducer.generateNotifications();
        return "Notifications generated successfully";
    }
    
}
