package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class UnregisteredTicketPurchaseDto {

    private String fiscalCode;
    private String customerName;
    private String customerSurname;
    private String customerEmail;
    private String phoneNumber;
    private Long eventId;
    private Double purchaseAmount;

}
