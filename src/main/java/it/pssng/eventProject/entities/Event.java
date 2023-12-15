package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private Long eventId;
    @Column(name = "event_name")
    private String eventName;
    @Column(name = "maximum_capacity")
    private int maximumCapacity;
    @Column(name = "event_date")
    private String eventDate;
    @Column(name = "event_category")
    private String eventCategory;
    @Column(name = "location_id")
    private Long locationId;
}
