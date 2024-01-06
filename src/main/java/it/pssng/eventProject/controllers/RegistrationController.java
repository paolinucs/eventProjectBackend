package it.pssng.eventProject.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.RegistrationDTO;
import it.pssng.eventProject.exception.DataNotCorrectlyPassedException;
import it.pssng.eventProject.services.dataTransfer.RegistrationDtoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/signup")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationDtoService registrationDtoService;
    private static Logger LOGGER = LoggerFactory.getLogger("RegistrationController");

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/customer")
    public ResponseEntity<RegistrationDTO> signUpAsCustomer(@RequestBody RegistrationDTO data) {
            try {
                RegistrationDTO savedDtoData = registrationDtoService.signUpCustomer(data);
                LOGGER.info("Operation /api/signup/customer: Data saved succesfully");
                return ResponseEntity.ok(savedDtoData);
            }catch(DataNotCorrectlyPassedException exc){
                LOGGER.info("Operation /api/signup/customer: Cannot save data because of data not correctly passed!");                
                return ResponseEntity.noContent().build();
            } 
    
    }
    
    @CrossOrigin(origins= "http://localhost:3000")
    @PostMapping("/promoter")
    public ResponseEntity<RegistrationDTO> signUpAsPromoter(@RequestBody RegistrationDTO data) {
            try {
                RegistrationDTO savedDtoData = registrationDtoService.signUpPromoter(data);
                LOGGER.info("Operation /api/signup/promoter: Data saved succesfully");
                return ResponseEntity.ok(savedDtoData);
            }catch(DataNotCorrectlyPassedException exc){
                LOGGER.info("Operation /api/signup/promoter: Cannot save data because of data not correctly passed!");                
                return ResponseEntity.noContent().build();
            } 
    
    }


}