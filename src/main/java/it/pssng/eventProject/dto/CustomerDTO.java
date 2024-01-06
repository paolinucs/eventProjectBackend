package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String fiscalCode;
    private String customerName;
    private String customerSurname;
    private String customerCity;
    private String customerNationality;
    private String customerBirthDate;
    private String customerEmail;
}