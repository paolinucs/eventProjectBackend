package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "location")
public class Location {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Location_id")
    public Long locationId;
    @Column(name="Location_address")
    public String locationAddress;
    @Column(name="Max_customers")
    public Long maxCustomers;
    @Column(name = "Location_name")
    public String locationName;
    @Column(name = "Location_description")
    public String locationDescription;
    @Column(name = "Promoter_id")
    public String promoterId;

    //GETTERS
    public Long getLocationId() {
        return locationId;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public Long getMaxCustomers() {
        return maxCustomers;
    }
    public String getLocationName(){ return locationName; }
    public String getLocationDescription(){ return locationDescription; }
    public String getPromoterId(){return promoterId; }

    //SETTERS

    public void setLocationId(Long idLocation) {
        this.locationId = locationId;
    }
    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }
    public void setMaxCustomers(Long maxCustomers) {
        this.maxCustomers = maxCustomers;
    }
    public void  setLocationName(String locationName) { this.locationName = locationName; }
    public void setLocationDescription(String locationDescription) { this.locationDescription = locationDescription; }
    public void setPromoterId(String promoterId) {this.promoterId = promoterId; }
}
