package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "location")
@Data
public class Location {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "location-id")
    private Long locationId;

    @Column(name = "location-address")
    private String locationAddress;

    @Column(name = "max-customers")
    private Long maxCustomers;

    @Column(name = "location-name")
    private String locationName;

    @Column(name = "location-description")
    private String locationDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter-fiscal-code", referencedColumnName = "promoter-fiscal-code")
    private Promoter promoterId;

}