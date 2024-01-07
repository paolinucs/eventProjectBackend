package it.pssng.eventProject.model;

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
    @JoinColumn(name = "customer-fiscal-code", referencedColumnName = "fiscal-code")
    private User joinedUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event-id", referencedColumnName = "event-id")
    private Event joinedEvent;
}
