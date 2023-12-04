package it.pssng.eventProject.services;
import it.pssng.eventProject.entities.User;
import it.pssng.eventProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public User findUserByUserName(String userName){
        Optional<User> foundStand = userRepository.findById(userName);
        return foundStand.orElse(null);
    }
}
