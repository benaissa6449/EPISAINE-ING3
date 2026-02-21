package fr.upec.sirius.episaine.kafka_backend.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventPayload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventsProducer {

    @Value("${app.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaEventsProducer(
            KafkaTemplate<String, String> kafkaTemplate,
            ObjectMapper objectMapper
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void publish(KafkaEventPayload payload) {
        try {
            String key = payload.customer_id() == null ? null : String.valueOf(payload.customer_id());
            String message = objectMapper.writeValueAsString(payload);
            kafkaTemplate.send(topic, key, message);
        } catch (JsonProcessingException ex) {
            throw new IllegalArgumentException("Unable to serialize payload", ex);
        }
    }
}
