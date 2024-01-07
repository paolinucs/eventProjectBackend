package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Customer;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.repos.CustomerRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer findCustomerById(Long id) {
        Optional<Customer> foundId = customerRepository.findById(id);
        return foundId.orElse(null);
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

    public Optional<Customer> findCustomerByFiscalCode(User fiscalCode) {
        return customerRepository.findCustomerByFiscalCode(fiscalCode);
    }

    public Optional<Customer> findCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

}
