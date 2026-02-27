package fr.upec.sirius.episaine.episaine_send_notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {
    private Integer id;
    private String ingredients;
    private String instructions;
    private Integer calories;
    private String mealName;
    private String category;
    private String areaId;
}
