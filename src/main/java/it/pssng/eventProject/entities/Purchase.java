package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "Purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Purchase_id")
    public Long purchaseId;

    @Column(name = "Purchase_date")
    public String purchaseDate;

    @Column(name = "Purchase_amount")
    public Double purchaseAmount;

    @Column(name = "Customer_id")
    public String customerId;

    @Column(name = "Ticket_id")
    public Long ticketId;


}
