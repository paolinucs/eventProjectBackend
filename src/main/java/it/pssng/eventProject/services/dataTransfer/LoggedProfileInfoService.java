package it.pssng.eventProject.services.dataTransfer;

import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.LoggedProfileInfoDTO;
import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.model.Customer;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.business.CustomerService;
import it.pssng.eventProject.services.business.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoggedProfileInfoService {

    private final CustomerService customerService;
    private final UserService userService;

    public LoggedProfileInfoDTO getProfileData(String fiscalCode) throws UserNotFoundException {
        Optional<User> fetchedUser = userService.findUserByFiscalCode(fiscalCode);
        if (!fetchedUser.isPresent())
            throw new UserNotFoundException();
        Optional<Customer> fetchedCustomer = customerService.findCustomerByFiscalCode(fetchedUser.get());
        LoggedProfileInfoDTO profileInfo = new LoggedProfileInfoDTO();
        profileInfo.setName(fetchedCustomer.get().getCustomerName());
        profileInfo.setSurname(fetchedCustomer.get().getCustomerSurname());
        profileInfo.setEmail(fetchedCustomer.get().getCustomerEmail());
        profileInfo.setFiscalCode(fetchedUser.get().getFiscalCode());
        profileInfo.setCity(fetchedCustomer.get().getCustomerCity());
        profileInfo.setAddress(fetchedCustomer.get().getCustomerAddress());
        profileInfo.setRole(fetchedUser.get().getRole());

        return profileInfo;

    }

}
