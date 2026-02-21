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
        KafkaEventEnvelope event = new KafkaEventEnvelope(
                record.topic(),
                record.partition(),
                record.offset(),
                record.key(),
                record.value(),
                payload != null ? payload.customer_id() : null,
                payload != null ? payload.recipes_id() : null,
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
}
