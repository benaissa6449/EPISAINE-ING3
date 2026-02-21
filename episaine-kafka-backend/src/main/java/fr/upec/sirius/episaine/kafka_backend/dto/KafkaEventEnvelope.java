package fr.upec.sirius.episaine.kafka_backend.dto;

import java.time.Instant;
import java.util.List;

public record KafkaEventEnvelope(
        String topic,
        Integer partition,
        Long offset,
        String key,
        String rawPayload,
        Integer customer_id,
        List<Integer> recipes_id,
        Instant receivedAt
) {
}
