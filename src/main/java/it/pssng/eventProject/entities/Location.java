package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Location_id")
    private Long locationId;
    @Column(name = "Location_address")
    private String locationAddress;
    @Column(name = "Max_customers")
    private Long maxCustomers;
    @Column(name = "Location_name")
    private String locationName;
    @Column(name = "Location_description")
    private String locationDescription;
    @Column(name = "Promoter_id")
    private String promoterId;

}