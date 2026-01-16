package fr.upec.sirius.episaine.episaine_cache_loader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.upec.sirius.episaine.episaine_cache_loader.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
