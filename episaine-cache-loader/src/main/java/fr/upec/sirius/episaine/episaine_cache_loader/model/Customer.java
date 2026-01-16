package fr.upec.sirius.episaine.episaine_cache_loader.model;

import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import fr.upec.sirius.episaine.episaine_cache_loader.enumerate.CustomerGender;
import fr.upec.sirius.episaine.episaine_cache_loader.enumerate.CustomerPreferedContact;
import fr.upec.sirius.episaine.episaine_cache_loader.enumerate.CustomerWeightGoal;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

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

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "allergies")
    private List<String> allergies;

    @Column(name = "intolerances")
    private List<String> intolerances;

    @Column(name = "disliked_ingredients")
    private List<String> dislikedIngredients;

    @Column(name = "diet_preferences")
    private List<String> dietPreferences;

    @Column(name = "area_preferences")
    private List<String> areaPreferences;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private CustomerGender gender = CustomerGender.OTHER;

    @Column(name = "height")
    private float height;

    @Column(name = "weight")
    private float weight;

    @Column(name = "meals_per_day")
    private int mealsPerDay;

    @Column(name = "number_of_days")
    private int numberOfDays;

    @Column(name = "last_notification")
    private Timestamp lastNotification;
}