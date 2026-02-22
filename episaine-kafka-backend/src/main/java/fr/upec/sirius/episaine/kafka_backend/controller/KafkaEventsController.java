package fr.upec.sirius.episaine.kafka_backend.controller;

import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventEnvelope;
import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventPageResponse;
import fr.upec.sirius.episaine.kafka_backend.dto.KafkaEventPayload;
import fr.upec.sirius.episaine.kafka_backend.kafka.KafkaEventsProducer;
import fr.upec.sirius.episaine.kafka_backend.service.KafkaEventStreamService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class KafkaEventsController {

    private final KafkaEventStreamService kafkaEventStreamService;
    private final KafkaEventsProducer kafkaEventsProducer;

    public KafkaEventsController(
            KafkaEventStreamService kafkaEventStreamService,
            KafkaEventsProducer kafkaEventsProducer
    ) {
        this.kafkaEventStreamService = kafkaEventStreamService;
        this.kafkaEventsProducer = kafkaEventsProducer;
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter stream() {
        return kafkaEventStreamService.subscribe();
    }

    @GetMapping("/latest")
    public List<KafkaEventEnvelope> latest(
            @RequestParam(defaultValue = "12") int limit
    ) {
        return kafkaEventStreamService.latest(limit);
    }

    @GetMapping("/page")
    public KafkaEventPageResponse page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int size
    ) {
        return kafkaEventStreamService.pageFromLatest(page, size);
    }

    @PostMapping("/publish")
    public void publish(@RequestBody KafkaEventPayload payload) {
        kafkaEventsProducer.publish(payload);
    }
}
