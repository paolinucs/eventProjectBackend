package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Purchase")
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase-id")
    public Long purchaseId;

    @Column(name = "purchase-date")
    public String purchaseDate;

    @Column(name = "purchase-amount")
    public Double purchaseAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer-fiscal-code", referencedColumnName = "customer-fiscal-code")
    public Customer JoinedCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket-id", referencedColumnName = "ticket-id")
    public Ticket joinedTicket;

}
