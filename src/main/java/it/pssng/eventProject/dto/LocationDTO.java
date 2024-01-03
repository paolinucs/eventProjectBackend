package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class LocationDTO {

    private String locationAddress;
    private Long maxCustomers;
    private String locationName;
    private String locationDescription;
    private String promoterId;

}
