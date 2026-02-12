package fr.upec.sirius.episaine.episaine_cache_loader.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerNotificationDTO {
    private int customer_id;
    private Timestamp lastNotification;
}