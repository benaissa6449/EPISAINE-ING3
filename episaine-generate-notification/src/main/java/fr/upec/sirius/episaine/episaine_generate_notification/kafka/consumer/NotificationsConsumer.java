package fr.upec.sirius.episaine.episaine_generate_notification.kafka.consumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.KafkaEventResponse;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationsConsumer {

    private static final String TOPIC = "sent-notifications";
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public List<KafkaEventResponse> consumeAll() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            List<TopicPartition> partitions = consumer.partitionsFor(TOPIC).stream()
                    .map(pi -> new TopicPartition(pi.topic(), pi.partition()))
                    .toList();
            consumer.assign(partitions);
            consumer.seekToBeginning(partitions);

            List<KafkaEventResponse> responses = new ArrayList<>();
            int emptyPolls = 0;

            while (emptyPolls < 3) {
                var records = consumer.poll(Duration.ofSeconds(2));
                if (records.isEmpty()) {
                    emptyPolls++;
                    continue;
                }
                emptyPolls = 0;
                for (ConsumerRecord<String, String> record : records) {
                    try {
                        responses.add(MAPPER.readValue(record.value(), KafkaEventResponse.class));
                    } catch (Exception e) {
                        log.warn("Skipping invalid record at offset {}: {}", record.offset(), e.getMessage());
                    }
                }
            }
            return responses;
        }
    }
}
