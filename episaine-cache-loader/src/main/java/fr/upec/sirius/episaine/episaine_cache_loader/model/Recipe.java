package fr.upec.sirius.episaine.episaine_cache_loader.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Table(name = "recipe")
public class Recipe {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "meal")
    private String meal;

    @Column(name = "category")
    private String category;

    @Column(name = "area_id")
    private String area_id;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "ingredients")
    private String ingredients;
}
