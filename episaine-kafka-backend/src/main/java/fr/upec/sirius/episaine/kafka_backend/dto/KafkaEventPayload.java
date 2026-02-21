package fr.upec.sirius.episaine.kafka_backend.dto;

import java.util.List;

public record KafkaEventPayload(
        Integer customer_id,
        List<Integer> recipes_id
) {
}
