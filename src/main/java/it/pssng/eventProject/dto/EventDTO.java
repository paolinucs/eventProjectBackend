package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class EventDTO {

    private String eventName;
    private int maximumCapacity;
    private String eventDate;
    private String eventCategory;
    private Long locationId;

}
