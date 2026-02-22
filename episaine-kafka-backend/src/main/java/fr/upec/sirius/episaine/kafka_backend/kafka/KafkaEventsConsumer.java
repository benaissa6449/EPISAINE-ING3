package fr.upec.sirius.episaine.kafka_backend.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventEnvelope;
import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventPayload;
import fr.upec.sirius.episaine.kafka_backend.service.KafkaEventStreamService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class KafkaEventsConsumer {
    private static final Logger log = LoggerFactory.getLogger(KafkaEventsConsumer.class);

    private final ObjectMapper objectMapper;
    private final KafkaEventStreamService kafkaEventStreamService;

    public KafkaEventsConsumer(
            ObjectMapper objectMapper,
            KafkaEventStreamService kafkaEventStreamService
    ) {
        this.objectMapper = objectMapper;
        this.kafkaEventStreamService = kafkaEventStreamService;
    }

    @KafkaListener(
            topics = "${app.kafka.topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void onMessage(ConsumerRecord<String, String> record) {
        KafkaEventPayload payload = parsePayload(record.value());
        String eventType = resolveEventType(payload);
        String userId = resolveUserId(payload);
        String route = resolveRoute(payload, record.topic());
        String eventAt = payload != null && payload.event_at() != null ? payload.event_at() : Instant.now().toString();
        String sessionStartedAt = payload != null ? payload.session_started_at() : null;
        Integer sessionDurationSeconds = payload != null ? payload.session_duration_seconds() : null;

        KafkaEventEnvelope event = new KafkaEventEnvelope(
                record.topic(),
                record.partition(),
                record.offset(),
                record.key(),
                record.value(),
                payload != null ? payload.customer_id() : null,
                payload != null ? payload.recipes_id() : null,
                eventType,
                userId,
                route,
                eventAt,
                sessionStartedAt,
                sessionDurationSeconds,
                Instant.now()
        );

        kafkaEventStreamService.publish(event);
        log.debug("Event consumed topic={} partition={} offset={}", record.topic(), record.partition(), record.offset());
    }

    private KafkaEventPayload parsePayload(String rawPayload) {
        try {
            return objectMapper.readValue(rawPayload, KafkaEventPayload.class);
        } catch (JsonProcessingException ex) {
            log.warn("Payload is not matching KafkaEventPayload schema, sending raw data only");
            return null;
        }
    }

    private String resolveEventType(KafkaEventPayload payload) {
        if (payload != null && payload.event_type() != null && !payload.event_type().isBlank()) {
            return payload.event_type();
        }
        return "profile";
    }

    private String resolveUserId(KafkaEventPayload payload) {
        if (payload != null && payload.user_id() != null && !payload.user_id().isBlank()) {
            return payload.user_id();
        }
        return null;
    }

    private String resolveRoute(KafkaEventPayload payload, String topic) {
        if (payload != null && payload.route() != null && !payload.route().isBlank()) {
            return payload.route();
        }
        if ("customer-profile".equals(topic)) {
            return "/customer-profile";
        }
        return "/activity";
    }
}
