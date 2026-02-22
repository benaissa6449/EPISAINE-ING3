package fr.upec.sirius.episaine.kafka_backend.dto;

import java.util.List;

public record KafkaEventPayload(
        Integer customer_id,
        List<Integer> recipes_id,
        String event_type,
        String user_id,
        String route,
        String event_at,
        String session_started_at,
        Integer session_duration_seconds
) {
}
