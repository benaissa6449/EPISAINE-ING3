package fr.upec.sirius.episaine.episaine_send_notification.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "meals", schema = "gold")
public class Recipe {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ingredients")
    private String ingredients;

    @Column(name = "strInstructions")
    private String instructions;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "strMeal")
    private String mealName;

    @Column(name = "strCategory")
    private String category;

    @Column(name = "area_id")
    private Integer areaId;
}
