package fr.upec.sirius.episaine.episaine_cache_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Recipe {
    private String meal;
    private String category;
    private String instructions;
    private String ingredients;
}
