package it.pssng.eventProject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.pssng.eventProject.model.Customer;
import it.pssng.eventProject.model.User;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.customerFiscalCode = :fiscalCode")
    public Optional<Customer> findCustomerByFiscalCode(@Param("fiscalCode") User fiscalCode);

    @Query("SELECT c FROM Customer c WHERE c.customerEmail = :email")
    public Optional<Customer> findCustomerByEmail(@Param("email") String email);
}
