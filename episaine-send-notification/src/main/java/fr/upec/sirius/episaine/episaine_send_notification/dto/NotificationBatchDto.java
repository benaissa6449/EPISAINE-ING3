package fr.upec.sirius.episaine.episaine_send_notification.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NotificationBatchDto {
    @JsonProperty("customer_id")
    private Integer customerId;
    
    @JsonProperty("recipes_id")
    private List<Integer> recipesId;
}
