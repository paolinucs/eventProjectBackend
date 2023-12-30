package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {

    // ATTRIBUTES
    @Id
    @Column(name = "customer-fiscal-code")
    private String customerFiscalCode;
    @Column(name = "customer-name")
    private String customerName;
    @Column(name = "customer-surname")
    private String customerSurname;
    @Column(name = "phone-number")
    private String phoneNumber;
    @Column(name = "e-mail", unique = true)
    private String customerEmail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User joinedUser;
}
