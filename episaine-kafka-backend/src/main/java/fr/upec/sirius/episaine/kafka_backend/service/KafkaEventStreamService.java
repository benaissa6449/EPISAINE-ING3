package fr.upec.sirius.episaine.kafka_backend.service;

import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventEnvelope;
import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventPageResponse;
import fr.upec.sirius.episaine.kafka_backend.dto.WeeklyKpiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class KafkaEventStreamService {

    private static final long SSE_TIMEOUT_MS = 0L;
    private final int maxHistory;

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    private final List<KafkaEventEnvelope> history = new CopyOnWriteArrayList<>();

    public KafkaEventStreamService(@Value("${app.events.max-history:5000}") int maxHistory) {
        this.maxHistory = Math.max(100, maxHistory);
    }

    public SseEmitter subscribe() {
        SseEmitter emitter = new SseEmitter(SSE_TIMEOUT_MS);
        emitters.add(emitter);

        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError((ex) -> emitters.remove(emitter));

        return emitter;
    }

    public void publish(KafkaEventEnvelope event) {
        appendToHistory(event);
        List<SseEmitter> deadEmitters = new ArrayList<>();

        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(SseEmitter.event()
                        .name("kafka-event")
                        .data(event));
            } catch (IOException ex) {
                deadEmitters.add(emitter);
            }
        }

        emitters.removeAll(deadEmitters);
    }

    public List<KafkaEventEnvelope> latest(int limit) {
        int safeLimit = Math.max(1, Math.min(limit, maxHistory));
        int size = history.size();
        int fromIndex = Math.max(0, size - safeLimit);
        // Return a detached copy to avoid concurrent view issues during JSON serialization.
        return new ArrayList<>(history.subList(fromIndex, size));
    }

    public KafkaEventPageResponse pageFromLatest(int page, int size) {
        int safeSize = Math.max(1, Math.min(size, 12));
        int safePage = Math.max(0, page);
        int totalItems = history.size();

        if (totalItems == 0) {
            return new KafkaEventPageResponse(safePage, safeSize, 0, 0, List.of());
        }

        int totalPages = (int) Math.ceil((double) totalItems / safeSize);
        if (safePage >= totalPages) {
            return new KafkaEventPageResponse(safePage, safeSize, totalItems, totalPages, List.of());
        }

        int newestIndexExclusive = totalItems - (safePage * safeSize);
        int newestIndexInclusive = Math.max(0, newestIndexExclusive - safeSize);

        List<KafkaEventEnvelope> window = new ArrayList<>(history.subList(newestIndexInclusive, newestIndexExclusive));
        java.util.Collections.reverse(window);
        return new KafkaEventPageResponse(safePage, safeSize, totalItems, totalPages, window);
    }

    public WeeklyKpiResponse weeklyKpi() {
        LocalDate todayUtc = LocalDate.now(ZoneOffset.UTC);
        LocalDate weekStart = todayUtc.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDate weekEnd = weekStart.plusDays(6);

        Instant startInclusive = weekStart.atStartOfDay().toInstant(ZoneOffset.UTC);
        Instant endExclusive = weekEnd.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC);

        int connexions = 0;
        int deconnexions = 0;
        int navigations = 0;
        int total = 0;

        for (KafkaEventEnvelope event : history) {
            Instant eventInstant = parseEventInstant(event);
            if (eventInstant == null || eventInstant.isBefore(startInclusive) || !eventInstant.isBefore(endExclusive)) {
                continue;
            }

            total += 1;
            String type = event.event_type();
            if ("connexion".equals(type)) {
                connexions += 1;
            } else if ("deconnexion".equals(type)) {
                deconnexions += 1;
            } else if ("navigation".equals(type)) {
                navigations += 1;
            }
        }

        return new WeeklyKpiResponse(
                weekStart.toString(),
                weekEnd.toString(),
                connexions,
                deconnexions,
                navigations,
                total
        );
    }

    private void appendToHistory(KafkaEventEnvelope event) {
        history.add(event);
        if (history.size() > maxHistory) {
            history.remove(0);
        }
    }

    private Instant parseEventInstant(KafkaEventEnvelope event) {
        try {
            if (event.event_at() != null && !event.event_at().isBlank()) {
                return Instant.parse(event.event_at());
            }
        } catch (Exception ignored) {
            // Fall back to receivedAt.
        }
        return event.receivedAt();
    }
}
