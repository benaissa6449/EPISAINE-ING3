package fr.upec.sirius.episaine.episaine_generate_notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.upec.sirius.episaine.episaine_generate_notification.data.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}
