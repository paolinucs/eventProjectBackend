package it.pssng.eventProject.services.dataTransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.business.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private static Logger LOGGER = LoggerFactory.getLogger("AuthenticationService");
    public final UserService userService;

    public boolean authenticate(User data) throws UserNotFoundException {
        User fetchedUser = userService.findUserByFiscalCode(data.getUserName());
        if (fetchedUser != null) {
            boolean isAuth = fetchedUser.getPassword().equals(data.getPassword());
            LOGGER.debug("Is User Authenticated " + isAuth);
            return isAuth;
        }
        throw new UserNotFoundException();
    }

}
