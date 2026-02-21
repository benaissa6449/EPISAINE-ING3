package fr.upec.sirius.episaine.kafka_backend.service;

import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventEnvelope;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class KafkaEventStreamService {

    private static final long SSE_TIMEOUT_MS = 0L;
    private static final int MAX_HISTORY = 200;

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
    private final List<KafkaEventEnvelope> history = new CopyOnWriteArrayList<>();

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
        int safeLimit = Math.max(1, Math.min(limit, MAX_HISTORY));
        int size = history.size();
        int fromIndex = Math.max(0, size - safeLimit);
        // Return a detached copy to avoid concurrent view issues during JSON serialization.
        return new ArrayList<>(history.subList(fromIndex, size));
    }

    private void appendToHistory(KafkaEventEnvelope event) {
        history.add(event);
        if (history.size() > MAX_HISTORY) {
            history.remove(0);
        }
    }
}
