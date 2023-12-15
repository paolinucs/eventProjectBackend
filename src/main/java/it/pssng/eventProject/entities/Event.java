package it.pssng.eventProject.entities;
import jakarta.persistence.*;

@Entity
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


    //getters and setters

    public Long getEventId(){
        return this.eventId;
    }

    public String getEventName(){
        return this.eventName;
    }

    public int getMaximumCapacity(){
        return this.maximumCapacity;
    }

    public String getEventDate(){
        return this.eventDate;
    }

    public String getEventCategory() {
        return eventCategory;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public void setEventCategory(String eventCategory) {
        this.eventCategory = eventCategory;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }


}
