package it.pssng.eventProject.services.dataTransfer;

import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.RegistrationDTO;
import it.pssng.eventProject.exception.DataNotCorrectlyPassedException;
import it.pssng.eventProject.model.Customer;
import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.business.CustomerService;
import it.pssng.eventProject.services.business.PromoterService;
import it.pssng.eventProject.services.business.UserService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationDtoService {

    private final UserService userService;
    private final PromoterService promoterService;
    private final CustomerService customerService;

    public RegistrationDTO signUpPromoter(RegistrationDTO newData) throws DataNotCorrectlyPassedException {

        if (newData == null)
            throw new DataNotCorrectlyPassedException();

        User newUserData = new User();
        newUserData.setFiscalCode(newData.getFiscalCode());
        newUserData.setPassword(newData.getPassword());
        newUserData.setRole("ROLE_PROMOTER");

        User savedUser = userService.saveNewUser(newUserData);

        Promoter newPromoterData = new Promoter();
        newPromoterData.setPromoterFiscalCode(newUserData);
        newPromoterData.setPromoterName(newData.getName());
        newPromoterData.setPromoterSurname(newData.getSurname());
        newPromoterData.setPromoterNationality(newData.getNationality());
        newPromoterData.setPromoterEmail(newData.getEmail());
        newPromoterData.setPromoterCity(newData.getCity());
        newPromoterData.setPromoterBirthDate(newData.getBirthDate());

        Promoter savedPromoter = promoterService.savePromoter(newPromoterData);

        RegistrationDTO returnData = new RegistrationDTO();
        returnData.setFiscalCode(savedPromoter.getPromoterFiscalCode().getFiscalCode());
        returnData.setName(savedPromoter.getPromoterName());
        returnData.setSurname(savedPromoter.getPromoterSurname());
        returnData.setNationality(savedPromoter.getPromoterNationality());
        returnData.setEmail(savedPromoter.getPromoterEmail());
        returnData.setCity(savedPromoter.getPromoterCity());
        returnData.setBirthDate(savedPromoter.getPromoterBirthDate());
        returnData.setPassword(savedUser.getPassword());
        returnData.setRole(savedUser.getRole());

        return returnData;
    }





    
    public RegistrationDTO signUpCustomer(RegistrationDTO newData) throws DataNotCorrectlyPassedException {

        if (newData == null)
            throw new DataNotCorrectlyPassedException();

        User newUserData = new User();
        newUserData.setFiscalCode(newData.getFiscalCode());
        newUserData.setPassword(newData.getPassword());
        newUserData.setRole("ROLE_CUSTOMER");

        User savedUser = userService.saveNewUser(newUserData);

        Customer newCustomerData = new Customer();
        newCustomerData.setCustomerFiscalCode(newUserData);
        newCustomerData.setCustomerName(newData.getName());
        newCustomerData.setCustomerSurname(newData.getSurname());
        newCustomerData.setCustomerNationality(newData.getNationality());
        newCustomerData.setCustomerEmail(newData.getEmail());
        newCustomerData.setCustomerCity(newData.getCity());
        newCustomerData.setCustomerBirthDate(newData.getBirthDate());

        Customer savedCustomer = customerService.saveCustomer(newCustomerData);

        RegistrationDTO returnData = new RegistrationDTO();
        returnData.setFiscalCode(savedCustomer.getCustomerFiscalCode().getFiscalCode());
        returnData.setName(savedCustomer.getCustomerName());
        returnData.setSurname(savedCustomer.getCustomerSurname());
        returnData.setNationality(savedCustomer.getCustomerNationality());
        returnData.setEmail(savedCustomer.getCustomerEmail());
        returnData.setCity(savedCustomer.getCustomerCity());
        returnData.setBirthDate(savedCustomer.getCustomerBirthDate());
        returnData.setPassword(savedUser.getPassword());
        returnData.setRole(savedUser.getRole());

        return returnData;
    }

}
