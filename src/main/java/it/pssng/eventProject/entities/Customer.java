package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Fiscal_code")
    private String fiscalCode;
    @Column(name = "Customer_name")
    private String customerName;
    @Column(name = "Customer_surname")
    private String customerSurname;
    @Column(name = "Customer_email")
    private String customerEmail;
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "Customer_username")
    private String customerUsername;
}
