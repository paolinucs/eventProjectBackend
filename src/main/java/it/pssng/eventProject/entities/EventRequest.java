package it.pssng.eventProject.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "event_request")
@Data
public class EventRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request-id")
    private Long eventRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter-id", referencedColumnName = "promoter-id")
    private Promoter joinedPromoter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location-id", referencedColumnName = "location-id")
    @Column(name = "location-id")
    private Location joinedLocation;

    @Column(name = "permission-document")
    private String permissionDocumentPath;
    @Column(name = "promoter-id-card")
    private String promoterIdCardPath;
    @Column(name = "event-request-date")
    private LocalDate eventRequestDate;
    @Column(name = "is-accepted")
    private boolean isAccepted;

}