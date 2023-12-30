package it.pssng.eventProject.entities;

import java.time.LocalDate;

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
    public LocalDate purchaseDate;

    @Column(name = "purchase-amount")
    public Double purchaseAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer-id", referencedColumnName = "customer-id")
    public String customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket-id", referencedColumnName = "ticket-id")
    public Ticket joinedTicket;

}
