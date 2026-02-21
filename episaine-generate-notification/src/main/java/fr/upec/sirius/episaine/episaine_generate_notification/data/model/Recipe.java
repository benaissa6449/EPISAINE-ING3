package fr.upec.sirius.episaine.episaine_generate_notification.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipe_id;

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
    private Integer area_id;
}