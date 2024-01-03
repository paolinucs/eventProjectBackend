package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket-id")
    private Long ticketId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer-fiscal-code", referencedColumnName = "customer-fiscal-code")
    private Customer joinedCustomer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event-id", referencedColumnName = "event-id")
    private Event joinedEvent;
}
