package it.pssng.eventProject.dto;

import lombok.Getter;
import lombok.Setter;

 @Getter
 @Setter
public class PurchaseDTO {

    public String purchaseData;
    public Double purchaseAmount;
    public String customerId;
    public Long tickerId;

}
