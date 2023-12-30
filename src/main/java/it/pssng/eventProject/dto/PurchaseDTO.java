package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class PurchaseDTO {

    public String purchaseData;
    public Double purchaseAmount;
    public String customerId;
    public Long tickerId;

}
