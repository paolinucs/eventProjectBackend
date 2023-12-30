package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.User;
import it.pssng.eventProject.repositories.UserRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findUserByUserName(String userName) {
        Optional<User> foundStand = userRepository.findById(userName);
        return foundStand.orElse(null);
    }
}
