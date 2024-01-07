package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer-id")
    private Long customerId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer-fiscal-code", referencedColumnName = "fiscal-code")
    private User customerFiscalCode;
    @Column(name = "customer-name")
    private String customerName;
    @Column(name = "customer-birthdate")
    private String customerBirthDate;
    @Column(name = "customer-surname")
    private String customerSurname;
    @Column(name = "customer-city")
    private String customerCity;
    @Column(name = "customer-address")
    private String customerAddress;
    @Column(name = "e-mail", unique = true)
    private String customerEmail;
    public void setPromoterName(String name) {
    }

}
