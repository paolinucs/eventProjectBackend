package it.pssng.eventProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseRequestDTO {
    public String purchaseRequestDate;
    public Double purchaseRequestAmount;
    public Long eventRequestId;
    public Long artistRequestId;
    public Long eventId;
    public Long standId;

}
