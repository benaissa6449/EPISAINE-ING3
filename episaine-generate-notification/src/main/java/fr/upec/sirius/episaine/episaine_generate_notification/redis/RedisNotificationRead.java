package fr.upec.sirius.episaine.episaine_generate_notification.redis;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisNotificationRead {
    private final RedisTemplate<String, Object> redisTemplate;

    private static final String ACTIVE_CUSTOMERS_PREFIX = "customers:active:";

    public List<Notification> getNotificationStateFromCache() {
        Set<String> keys = redisTemplate.keys(ACTIVE_CUSTOMERS_PREFIX + "*");
        if (keys == null || keys.isEmpty()) {
            return List.of();
        }

        List<Notification> notifications = new ArrayList<>();
        for (String key : keys) {
            try {
                int customerId = Integer.parseInt(key.substring(ACTIVE_CUSTOMERS_PREFIX.length()));
                String value = (String) redisTemplate.opsForValue().get(key);
                if (value == null) continue;

                String[] parts = value.split(":");
                long epochSeconds = Long.parseLong(parts[parts.length - 1]);
                Timestamp lastNotification = Timestamp.from(Instant.ofEpochSecond(epochSeconds));

                notifications.add(Notification.builder()
                        .customer_id(customerId)
                        .lastNotification(lastNotification)
                        .build());
            } catch (Exception e) {
                log.warn("Skipping invalid cache entry {}: {}", key, e.getMessage());
            }
        }
        return notifications;
    }
}