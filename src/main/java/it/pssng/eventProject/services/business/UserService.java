package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.User;
import it.pssng.eventProject.repos.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveNewUser(User newUserData) {
        return userRepository.save(newUserData);
    }

    public User findUserByFiscalCode(String fiscalCode) {
        Optional<User> fetchedUser = userRepository.findUserByFiscalCode(fiscalCode);
        return fetchedUser.orElse(null);
    }

}
