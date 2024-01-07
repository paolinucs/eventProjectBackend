package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event-id")
    private Long eventId;
    @Column(name = "event-name")
    private String eventName;
    @Column(name = "event-description")
    private String eventDescription;
    @Column(name = "maximum-capacity")
    private Long maximumCapacity;
    @Column(name = "event-region")
    private String eventRegion;
    @Column(name = "event-start-date")
    private String eventStartDate;
    @Column(name = "event-end-date")
    private String eventEndDate;
    @Column(name = "event-category")
    private String eventCategory;
    @Column(name = "event-pic-path")
    private String eventPicPath;
    @Column(name = "event-price")
    private Double eventPrice;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location-id", referencedColumnName = "location-id")
    private Location joinedLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter-id", referencedColumnName = "promoter-id")
    private Promoter joinedPromoter;
}
