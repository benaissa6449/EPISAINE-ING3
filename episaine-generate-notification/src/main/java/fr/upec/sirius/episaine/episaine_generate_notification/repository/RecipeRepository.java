package fr.upec.sirius.episaine.episaine_generate_notification.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.upec.sirius.episaine.episaine_generate_notification.data.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    @Query(value = """
            SELECT * FROM gold.meals m
            WHERE m.calories BETWEEN :minCal AND :maxCal
            AND m.id NOT IN (:excludedIds)
            """, nativeQuery = true)
    List<Recipe> findFilteredRecipes(
            @Param("minCal") int minCal,
            @Param("maxCal") int maxCal,
            @Param("excludedIds") List<Integer> excludedIds);
}
