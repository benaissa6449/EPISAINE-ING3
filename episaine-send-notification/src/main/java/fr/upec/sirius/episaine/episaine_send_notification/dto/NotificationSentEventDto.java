package fr.upec.sirius.episaine.episaine_send_notification.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSentEventDto {
    @JsonProperty("customer_id")
    private Integer customerId;

    @JsonProperty("recipes_id")
    private List<Integer> recipesId;
}
