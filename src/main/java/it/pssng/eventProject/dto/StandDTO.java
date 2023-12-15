package it.pssng.eventProject.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StandDTO {
    private Long standID;
    private Long eventID;
    private Long artistID;
    private boolean isTaken;
}
