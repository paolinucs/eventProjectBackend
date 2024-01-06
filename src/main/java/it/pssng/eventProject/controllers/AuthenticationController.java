package it.pssng.eventProject.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.dataTransfer.AuthenticationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private static Logger LOGGER = LoggerFactory.getLogger("AuthenticationController");

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public void login(@RequestBody User data) throws UserNotFoundException {
        boolean isAuthorized = false;

        try {
            isAuthorized = authenticationService.authenticate(data);
        } catch (UserNotFoundException exc) {
            ResponseEntity.notFound().build();
        }

        if (isAuthorized)
            ResponseEntity.ok().build();
        else
            ResponseEntity.badRequest().build();
    }

}
