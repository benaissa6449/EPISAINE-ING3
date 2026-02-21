package fr.upec.sirius.episaine.episaine_generate_notification.data.model;

import java.sql.Timestamp;
import java.util.List;

import fr.upec.sirius.episaine.episaine_generate_notification.data.enums.CustomerGender;
import fr.upec.sirius.episaine.episaine_generate_notification.data.enums.CustomerPreferedContact;
import fr.upec.sirius.episaine.episaine_generate_notification.data.enums.CustomerWeightGoal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "customers", schema = "gold")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Enumerated(EnumType.STRING)
    @Column(name = "prefered_contact")
    private CustomerPreferedContact preferedContact = CustomerPreferedContact.EMAIL;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "weight_goal")
    private CustomerWeightGoal weightGoal = CustomerWeightGoal.MAINTAIN_WEIGHT;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private CustomerGender gender = CustomerGender.OTHER;

    @Column(name = "height")
    private double height;

    @Column(name = "weight")
    private double weight;

    @Column(name = "meals_per_day")
    private int mealsPerDay;

    @Column(name = "activity_level")
    private int activityLevel;

    @Column(name = "diet_type")
    private String dietType;

    @Column(name = "allergies")
    private List<String> allergies;

    @Column(name = "conditions")
    private List<String> conditions;

    @Column(name = "favorite_cuisines")
    private List<String> favoriteCuisines;

    @Column(name = "disliked_ingredients")
    private List<String> dislikedIngredients;

    @Column(name = "prefered_meal_times")
    private List<String> preferedMealTimes;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "newsletter_opt_in")
    private boolean newsletterOptIn;

    @Column(name = "last_notification")
    private Timestamp lastNotification;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
