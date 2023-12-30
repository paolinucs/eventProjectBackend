package it.pssng.eventProject.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "purchase-request")
@Data
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchaserequest-id")
    public Long purchaseRequestId;

    @Column(name = "purchaserequest-date")
    public LocalDate purchaseRequestDate;

    @Column(name = "puchaserequest-amount")
    public Double purchaseRequestAmount;

    @Column(name = "eventrequest-id")
    public Long eventRequestId;

    @Column(name = "artistrequest-id")
    public Long artistRequestId;

    @Column(name = "event-id")
    public Long eventId;

    @Column(name = "stand-id")
    public Long standId;

}