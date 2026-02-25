package fr.upec.sirius.episaine.episaine_cache_loader.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fr.upec.sirius.episaine.episaine_cache_loader.data.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.newsletterOptIn = true")
    Page<Customer> findAllByNewsletterOptInTrue(Pageable pageable);
}
