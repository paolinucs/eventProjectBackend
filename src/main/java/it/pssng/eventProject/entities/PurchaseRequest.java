package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Purchase_request")
@Getter
@Setter
public class PurchaseRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PurchaseRequest_id")
    public Long purchaseRequestId;

    @Column(name = "PurchaseRequest_date")
    public String purchaseRequestDate;

    @Column(name = "PurchaseRequest_amount")
    public Double purchaseRequestAmount;

    @Column(name = "EventRequest_id")
    public Long eventRequestId;

    @Column(name = "ArtistRequest_id")
    public Long artistRequestId;

    @Column(name = "Event_id")
    public Long eventId;

    @Column(name = "Stand_id")
    public Long standId;

}