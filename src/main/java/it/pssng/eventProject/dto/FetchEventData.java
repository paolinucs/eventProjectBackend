package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class FetchEventData {
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private Long maximumCapacity;
    private String eventStartDate;
    private String eventEndDate;
    private String eventCategory;
    private String locationName;
    private String eventPicPath;
    private String eventRegion;
    private Double eventPrice;
    private String promoterNameSurname;
    private String promoterEmail;
}
