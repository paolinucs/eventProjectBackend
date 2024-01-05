package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class EventRequestDTO {
    private Long eventRequestId;
    private Long promoterId;
    private String permissionDocumentPath;
    private String promoterIdCardPath;
    private String eventRequestDate;
    private boolean isAccepted;
    
    private String locationAddress;
    private Long maxCustomers;
    private String locationName;
    private String locationDescription;
}
