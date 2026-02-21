package fr.upec.sirius.episaine.episaine_generate_notification.data.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KafkaEventResponse {
    private int customer_id;
    private List<Integer> recipes_id;
}
