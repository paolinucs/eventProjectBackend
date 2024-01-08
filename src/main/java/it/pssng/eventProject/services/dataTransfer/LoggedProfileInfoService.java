package it.pssng.eventProject.services.dataTransfer;

import java.util.Optional;

import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.LoggedProfileInfoDTO;
import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.model.Customer;
import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.business.CustomerService;
import it.pssng.eventProject.services.business.PromoterService;
import it.pssng.eventProject.services.business.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoggedProfileInfoService {

    private final CustomerService customerService;
    private final PromoterService promoterService;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public LoggedProfileInfoDTO getProfileData(String fiscalCode, String authKey) throws UserNotFoundException {
        Optional<User> fetchedUser = userService.findUserByFiscalCode(fiscalCode);
        if (!fetchedUser.isPresent())
            throw new UserNotFoundException();

            LoggedProfileInfoDTO profileInfo = new LoggedProfileInfoDTO();
        if(authenticationService.isCustomer(authKey)){
            Optional<Customer> fetchedCustomer = customerService.findCustomerByFiscalCode(fetchedUser.get());
            profileInfo.setName(fetchedCustomer.get().getCustomerName());
            profileInfo.setSurname(fetchedCustomer.get().getCustomerSurname());
            profileInfo.setEmail(fetchedCustomer.get().getCustomerEmail());
            profileInfo.setFiscalCode(fetchedUser.get().getFiscalCode());
            profileInfo.setCity(fetchedCustomer.get().getCustomerCity());
            profileInfo.setAddress(fetchedCustomer.get().getCustomerAddress());
            profileInfo.setRole(fetchedUser.get().getRole());

        }

        if(authenticationService.isPromoter(authKey)){
            Optional<Promoter> fetchedPromoter = promoterService.findPromoterByFiscalCode(fetchedUser.get());
            profileInfo.setName(fetchedPromoter.get().getPromoterName());
            profileInfo.setSurname(fetchedPromoter.get().getPromoterSurname());
            profileInfo.setEmail(fetchedPromoter.get().getPromoterEmail());
            profileInfo.setFiscalCode(fetchedUser.get().getFiscalCode());
            profileInfo.setCity(fetchedPromoter.get().getPromoterCity());
            profileInfo.setRole(fetchedUser.get().getRole());
        }



        return profileInfo;

    }

}
