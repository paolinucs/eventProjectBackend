package it.pssng.eventProject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Purchase_request")
public class Purchase_request {
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

    //GETTERS
    public Long getPurchaseRequestId() {
        return purchaseRequestId;
    }

    public String getPurchaseRequestDate() {
        return purchaseRequestDate;
    }

    public Double getPurchaseRequestAmount() {
        return purchaseRequestAmount;
    }

    public Long getEventRequestId() {
        return eventRequestId;
    }

    public Long getArtistRequestId() {
        return artistRequestId;
    }

    public Long getEventId() {
        return eventId;
    }

    public Long getStandId() {
        return standId;
    }

    //SETTERS

    public void setPurchaseRequestId(Long purchaseRequestId) {
        this.purchaseRequestId = purchaseRequestId;
    }

    public void setPurchaseRequestDate(String purchaseRequestDate) {
        this.purchaseRequestDate = purchaseRequestDate;
    }

    public void setPurchaseRequestAmount(Double purchaseRequestAmount) {
        this.purchaseRequestAmount = purchaseRequestAmount;
    }

    public void setEventRequestId(Long eventRequestId) {
        this.eventRequestId = eventRequestId;
    }

    public void setArtistRequestId(Long artistRequestId) {
        this.artistRequestId = artistRequestId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setStandId(Long standId) {
        this.standId = standId;
    }
}
