package it.pssng.eventProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtworkDTO {

    private int numberOfWorks;
    private int maximumCapacity;
    private String artworkTheme;
    private String description;
    private Long location;
    private String dateAndTime;

}
