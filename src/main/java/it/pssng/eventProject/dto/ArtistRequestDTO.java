package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class ArtistRequestDTO {

    private String artistId;
    private Long standId;
    private boolean isAccepted;

}
