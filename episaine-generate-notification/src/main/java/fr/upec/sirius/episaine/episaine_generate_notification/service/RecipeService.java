package fr.upec.sirius.episaine.episaine_generate_notification.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.upec.sirius.episaine.episaine_generate_notification.data.dto.KafkaEventResponse;
import fr.upec.sirius.episaine.episaine_generate_notification.data.enums.CustomerGender;
import fr.upec.sirius.episaine.episaine_generate_notification.data.enums.CustomerWeightGoal;
import fr.upec.sirius.episaine.episaine_generate_notification.data.model.Customer;
import fr.upec.sirius.episaine.episaine_generate_notification.data.model.Recipe;
import fr.upec.sirius.episaine.episaine_generate_notification.repository.CustomerRepository;
import fr.upec.sirius.episaine.episaine_generate_notification.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final CustomerRepository customerRepository;

    public List<Recipe> getRecipesForCustomer(int customerId, List<KafkaEventResponse> kafkaEvents) {
        List<Integer> alreadySentRecipeIds = kafkaEvents.stream()
                .filter(event -> event.getCustomer_id() == customerId)
                .flatMap(event -> event.getRecipes_id().stream())
                .distinct()
                .toList();

        Optional<Customer> optCustomer = customerRepository.findById(customerId);
        if (optCustomer.isEmpty()) {
            log.warn("Customer {} not found in database, skipping", customerId);
            return Collections.emptyList();
        }
        Customer customer = optCustomer.get();

        int caloriesPerMeal = calculateCaloriesPerMeal(customer);
        log.info("Customer {} : goal {} kcal/meal ({} meal/day)",
                customerId, caloriesPerMeal, customer.getMealsPerDay());

        int minCal = (int) (caloriesPerMeal * 0.8);
        int maxCal = (int) (caloriesPerMeal * 1.2);

        // Éviter une liste vide pour la clause NOT IN (problème SQL)
        List<Integer> excludedIds = alreadySentRecipeIds.isEmpty()
                ? List.of(-1)
                : alreadySentRecipeIds;

        // Filtrage côté BD : calories, recettes déjà envoyées
        List<Recipe> dbRecipes = recipeRepository.findFilteredRecipes(
                minCal, maxCal, excludedIds);

        // Filtrage côté serveur : allergies et ingrédients non aimés (champ texte libre)
        // Limiter au nombre de repas par jour (meals_per_day)
        int mealsPerDay = Math.max(customer.getMealsPerDay(), 1);
        List<Recipe> filteredRecipes = dbRecipes.stream()
                .filter(recipe -> matchesIngredients(recipe, customer))
                .limit(mealsPerDay)
                .toList();

        log.info("Customer {} : {} recipes from DB, {} sent (limited to {} meals/day)",
                customerId, dbRecipes.size(), filteredRecipes.size(), mealsPerDay);

        return filteredRecipes;
    }

    /**
     * Vérifie que les ingrédients de la recette ne contiennent pas d'allergènes
     * ni d'ingrédients non aimés du customer.
     * Ce filtrage reste côté serveur car le champ ingredients est du texte libre.
     */
    private boolean matchesIngredients(Recipe recipe, Customer customer) {
        if (recipe.getIngredients() == null) {
            return true;
        }
        String ingredientsLower = recipe.getIngredients().toLowerCase();

        if (customer.getAllergies() != null) {
            for (String allergy : customer.getAllergies()) {
                if (ingredientsLower.contains(allergy.toLowerCase())) {
                    return false;
                }
            }
        }

        if (customer.getDislikedIngredients() != null) {
            for (String disliked : customer.getDislikedIngredients()) {
                if (ingredientsLower.contains(disliked.toLowerCase())) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Calculate the target calories per meal for the customer based on their profile and goals.
     * @param customer the customer for whom to calculate the calories per meal
     * @return the target calories per meal
     */
    private int calculateCaloriesPerMeal(Customer customer) {
        // 1. BMR (Mifflin-St Jeor)
        double bmr;
        if (customer.getGender() == CustomerGender.MALE) {
            bmr = 10 * customer.getWeight() + 6.25 * customer.getHeight() - 5 * customer.getAge() + 5;
        } else {
            bmr = 10 * customer.getWeight() + 6.25 * customer.getHeight() - 5 * customer.getAge() - 161;
        }

        double tdee = bmr;

        if (customer.getWeightGoal() == CustomerWeightGoal.LOSE_WEIGHT) {
            tdee -= 500;
        } else if (customer.getWeightGoal() == CustomerWeightGoal.GAIN_WEIGHT) {
            tdee += 500;
        }

        int mealsPerDay = Math.max(customer.getMealsPerDay(), 1);
        return (int) Math.round(tdee / mealsPerDay);
    }

}
