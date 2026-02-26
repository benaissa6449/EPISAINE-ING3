package fr.upec.sirius.episaine.episaine_send_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.upec.sirius.episaine.episaine_send_notification.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
