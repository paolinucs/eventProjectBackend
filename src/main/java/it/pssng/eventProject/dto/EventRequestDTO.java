package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class EventRequestDTO {
    private Long eventRequestId;
    private Long promoterId;
    private String permissionDocumentPath;
    private String promoterIdCardPath;
    private String eventRequestDate;
    private String expectedEventStart;
    private String expectedEventEnd;
    private boolean isAccepted;
    private String eventName;
    private String eventDescription;
    private String eventRegion;
    private String eventPicPath;
    private Double eventPrice;
    private String eventCategory;

    private String locationAddress;
    private Long maxCustomers;
    private String locationName;
    private String locationDescription;
}
