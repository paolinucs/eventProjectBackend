package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "event_request")
@Data
public class EventRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event-request-id")
    private Long eventRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter-fiscal-code", referencedColumnName = "promoter-fiscal-code")
    private Promoter joinedPromoter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location-id", referencedColumnName = "location-id")
    private Location joinedLocation;

    @Column(name = "permission-document")
    private String permissionDocumentPath;
    @Column(name = "promoter-id-card")
    private String promoterIdCardPath;
    @Column(name = "event-request-date")
    private String eventRequestDate;
    @Column(name = "is-accepted")
    private boolean isAccepted;

}