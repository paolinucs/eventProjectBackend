package it.pssng.eventProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRequestDTO {


    private Long promoterId;

    private Long locationId;

    private String permissionDocumentURL;

    private String promoterIdCardURL;

    private String eventRequestDate;

    private boolean isAccepted;
}
