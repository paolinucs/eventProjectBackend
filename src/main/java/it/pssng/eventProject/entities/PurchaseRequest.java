package it.pssng.eventProject.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "purchase-request")
public class PurchaseRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "purchase-request-id")
    private Long purchaseRequestId;

    @Column(name = "purchase-request-date")
    private LocalDate purchaseRequestDate;

    @Column(name = "purchase-request-amount")
    private Double purchaseRequestAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event-request-id", referencedColumnName = "event-request-id")
    private EventRequest joinedEventRequest;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist-request-id", referencedColumnName = "artist-request-id")
    private ArtistRequest joinedArtistRequest;

}
