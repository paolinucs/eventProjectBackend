package it.pssng.eventProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArtistRequestDTO {

    private String artistId;
    private Long standId;
    private boolean isAccepted;

}
