package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Customer;
import it.pssng.eventProject.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer findCustomerByFiscalCode(String fiscalCode) {
        Optional<Customer> foundCustomer = customerRepository.findById(fiscalCode);
        return foundCustomer.orElse(null);
    }

    public List<Customer> findListAll() {
        List<Customer> foundCustomer = customerRepository.findAll();
        return foundCustomer;
    }

    public Customer saveCustomer(Customer data) {
        return customerRepository.save(data);
    }

    public boolean deleteCustomer(Customer data) {
        try {
            customerRepository.delete(data);
        } catch (Exception exc) {
            throw new RuntimeException();
        }

        return true;
    }

}
