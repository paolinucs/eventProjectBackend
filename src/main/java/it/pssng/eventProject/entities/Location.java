package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "location")
public class Location {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="location_id")
    public Long idLocation;
    @Column(name="location_address")
    public String locationAddress;
    @Column(name="max_customers")
    public int maxCustomers;

    //GETTERS
    public Long getIdLocation() {
        return idLocation;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public int getMaxCustomers() {
        return maxCustomers;
    }

    //SETTERS

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void setMaxCustomers(int maxCustomers) {
        this.maxCustomers = maxCustomers;
    }
}
