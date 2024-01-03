package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class PurchaseDTO {

    private String purchaseDate;
    private Double purchaseAmount;
    private String customerId;
    private Long ticketId;

}
