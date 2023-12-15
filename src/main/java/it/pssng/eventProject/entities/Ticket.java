package it.pssng.eventProject.entities;

import jakarta.persistence.*;

@Entity
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

    // GETTERS
    public Long getTicketCode() {
        return ticketCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Long getEventId() {
        return eventId;
    }

    // SETTERS
    public void setTicketCode(Long ticketCode) {
        this.ticketCode = ticketCode;
    }

    public void setExhibitionCode(String customerId) {
        this.customerId = customerId;
    }

    public void setIdCode(Long eventId) {
        this.eventId = eventId;
    }

}
