package it.pssng.eventProject.services.dataTransfer;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.UserDTO;
import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.business.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Value("${eventProject.test.authentication.key.promoter}")
    private String promoterAuthKey;
    @Value("${eventProject.test.authentication.key.customer}")
    private String customerAuthKey;
    private static Logger LOGGER = LoggerFactory.getLogger("AuthenticationService");
    public final UserService userService;

    public String authenticate(UserDTO data) throws UserNotFoundException {
        LOGGER.debug("Authentication Started.");
        Optional<User> optionalUser = userService.findUserByFiscalCode(data.getFiscalCode());
        if (optionalUser.isPresent()) {
            LOGGER.debug("User found");
            User fetchedUser = optionalUser.get();
            boolean isAuth = fetchedUser.getPassword().equals(data.getPassword());
            LOGGER.debug("Is User Authenticated " + isAuth);
            if (isAuth) {
                if (fetchedUser.getRole() == "ROLE_PROMOTER") {
                    return this.promoterAuthKey;
                } else {
                    return this.customerAuthKey;
                }
            }
            return "Unauthorized";
        }
        throw new UserNotFoundException();
    }

    public boolean isCustomer(String key){
        return key.equals(this.customerAuthKey);
    }

    public boolean isPromoter(String key){
        return key.equals(this.promoterAuthKey);
    }

}
