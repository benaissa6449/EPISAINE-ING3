package fr.upec.sirius.episaine.episaine_cache_backend.model;

import fr.upec.sirius.episaine.episaine_cache_backend.enumerate.CustomerPreferedContact;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String firstName;
    private String lastName;
    private CustomerPreferedContact preferedContact = CustomerPreferedContact.EMAIL;
    private String phoneNumber;
    private String email;
}