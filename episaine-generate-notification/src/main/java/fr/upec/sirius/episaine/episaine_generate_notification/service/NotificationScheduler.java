package fr.upec.sirius.episaine.episaine_generate_notification.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import fr.upec.sirius.episaine.episaine_generate_notification.kafka.producer.NotificationsProducer;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationScheduler {
    private final NotificationsProducer notificationsProducer;


    @Scheduled(initialDelay = 0, fixedRate = 24 * 60 * 60 * 1000)
    public void loadCustomersToCache() {
        System.out.println("Loading customers to cache...");
        notificationsProducer.generateNotifications();
    }
}