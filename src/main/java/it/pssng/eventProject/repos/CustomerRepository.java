package it.pssng.eventProject.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
