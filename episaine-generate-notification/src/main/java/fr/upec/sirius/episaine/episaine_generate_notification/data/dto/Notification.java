package fr.upec.sirius.episaine.episaine_generate_notification.data.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private int customer_id;
    private Timestamp lastNotification;
}
