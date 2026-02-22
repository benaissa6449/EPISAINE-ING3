package fr.upec.sirius.episaine.kafka_backend.dto;

public record WeeklyKpiResponse(
        String week_start,
        String week_end,
        int connexions,
        int deconnexions,
        int navigations,
        int total_events
) {
}
