package fr.upec.sirius.episaine.kafka_backend.dto;

import java.util.List;

public record KafkaEventPageResponse(
        int page,
        int size,
        int totalItems,
        int totalPages,
        List<KafkaEventEnvelope> items
) {
}
