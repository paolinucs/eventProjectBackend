package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class EventDTO {
    private Long eventId;
    private String eventName;
    private String eventDescription;
    private int maximumCapacity;
    private String eventDate;
    private String eventCategory;
    private Long locationId;
}
