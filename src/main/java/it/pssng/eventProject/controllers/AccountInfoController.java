package it.pssng.eventProject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.LoggedProfileInfoDTO;
import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.services.dataTransfer.LoggedProfileInfoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth/")
public class AccountInfoController {

    private final LoggedProfileInfoService loggedProfileInfoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/retrieve_info/{fiscalCode}")
    public ResponseEntity<LoggedProfileInfoDTO> retrievePromoterInfo(@PathVariable String fiscalCode, @RequestHeader("authKey") String key)
            throws UserNotFoundException {
        try {
            LoggedProfileInfoDTO fetchedData = loggedProfileInfoService.getProfileData(fiscalCode,key);
            return ResponseEntity.ok(fetchedData);
        } catch (UserNotFoundException exc) {
            return ResponseEntity.notFound().build();
        }
    }

}
