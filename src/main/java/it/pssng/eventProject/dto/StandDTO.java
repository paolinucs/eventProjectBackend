package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class StandDTO {
    private Long standID;
    private Long eventID;
    private Long artistID;
    private boolean isTaken;
}
