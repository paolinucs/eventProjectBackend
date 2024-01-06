package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class PromoterDTO {
    private Long promoterId;
    private String promoterFiscalCode;
    private String promoterName;
    private String promoterBirthDate;
    private String promoterSurname;
    private String promoterCity;
    private String promoterNationality;
    private String promoterEmail;
}
