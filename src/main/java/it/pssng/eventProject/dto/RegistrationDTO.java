package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class RegistrationDTO {
    private String fiscalCode;
    private String name;
    private String surname;
    private String city;
    private String nationality;
    private String birthDate;
    private String email;
    private String password;
    private String role;

}
