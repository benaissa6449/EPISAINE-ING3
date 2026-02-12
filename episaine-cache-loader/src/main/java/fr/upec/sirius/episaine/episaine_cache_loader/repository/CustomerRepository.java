package fr.upec.sirius.episaine.episaine_cache_loader.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.upec.sirius.episaine.episaine_cache_loader.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.newsletterOptIn = true")
    public List<Customer> findAllByNewsletterOptInTrue();
}
