package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class PurchaseRequestDTO {
    public String purchaseRequestDate;
    public Double purchaseRequestAmount;
    public Long eventRequestId;
    public Long artistRequestId;
    public Long eventId;
    public Long standId;

}
