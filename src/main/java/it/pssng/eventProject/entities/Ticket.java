package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class Ticket {

    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Ticket_id")
    private Long ticketCode;
    @Column(name = "Customer_id")
    private String customerId;
    @Column(name = "Event_id")
    private Long eventId;
}
