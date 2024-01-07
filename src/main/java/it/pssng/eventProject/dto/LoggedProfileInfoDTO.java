package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class LoggedProfileInfoDTO {
    private String name;
    private String surname;
    private String birthDate;
    private String email;
    private String city;
    private String address;
    private String fiscalCode;
    private String role;

}
