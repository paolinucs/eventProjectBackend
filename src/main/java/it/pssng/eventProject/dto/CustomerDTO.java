package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private String fiscalCode;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String phoneNumber;
    private String customerUsername;

}