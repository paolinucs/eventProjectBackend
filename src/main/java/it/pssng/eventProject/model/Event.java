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
    private int maximumCapacity;
    @Column(name = "event-date")
    private String eventDate;
    @Column(name = "event-category")
    private String eventCategory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location-id", referencedColumnName = "location-id")
    private Location joinedLocation;
}
