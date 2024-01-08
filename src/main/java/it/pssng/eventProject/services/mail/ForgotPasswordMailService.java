package it.pssng.eventProject.services.mail;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.model.Customer;
import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.business.CustomerService;
import it.pssng.eventProject.services.business.PromoterService;
import it.pssng.eventProject.services.business.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ForgotPasswordMailService {

    private final GenericMailClass genericMailClass;
    private final UserService userService;
    private final CustomerService customerService;
    private final PromoterService promoterService;

    @Value("${eventProject.email.ticket}")
    private String mailSupport;

    @Value("${eventProject.disclaimer}")
    private String disclaimer;

    public void sendNewTicket(String userFiscalCode) throws UserNotFoundException {

        Optional<User> userData = userService.findUserByFiscalCode(userFiscalCode);

        if (!userData.isPresent())
            throw new UserNotFoundException();

        Optional<Customer> customerData = customerService.findCustomerByFiscalCode(userData.get());
        Optional<Promoter> promoterData = promoterService.findPromoterByFiscalCode(userData.get());

        String mailSubject = "eventProject password Support.";

        if (customerData.isPresent()) {
            String mailTextCustomer = "Hi " + customerData.get().getCustomerName() + " "
                    + customerData.get().getCustomerSurname()
                    + ",\nIt seems that you forgot your customer's account password.\nHere it is: "
                    + userData.get().getPassword() + "\n\n\n\n" + this.disclaimer;
            String userEmail = customerData.get().getCustomerEmail();
            genericMailClass.sendSimpleMessage(mailSupport, userEmail, mailSubject, mailTextCustomer);
        }

        if (promoterData.isPresent()) {
            String mailTextPromoter = "Hi " + promoterData.get().getPromoterName() + " "
                    + promoterData.get().getPromoterSurname()
                    + ",\nIt seems that you forgot your promoter's account password.\nHere it is: "
                    + userData.get().getPassword() + "\n\n\n\n" + this.disclaimer;
            String userEmail = promoterData.get().getPromoterEmail();
            genericMailClass.sendSimpleMessage(mailSupport, userEmail, mailSubject, mailTextPromoter);
        }

    }

}
