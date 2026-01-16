package fr.upec.sirius.episaine.episaine_cache_loader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.upec.sirius.episaine.episaine_cache_loader.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    
}
