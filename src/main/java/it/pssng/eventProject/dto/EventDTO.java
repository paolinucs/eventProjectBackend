package it.pssng.eventProject.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EventDTO {

    private String eventName;
    private int maximumCapacity;
    private String eventDate;
    private String eventCategory;
    private Long locationId;

}
