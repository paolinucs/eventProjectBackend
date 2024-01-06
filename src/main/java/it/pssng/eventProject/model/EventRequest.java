package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "event-request")
@Data
public class EventRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event-request-id")
    private Long eventRequestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter-fiscal-code", referencedColumnName = "promoter-fiscal-code")
    private Promoter joinedPromoter;

    @Column(name = "permission-document")
    private String permissionDocumentPath;
    @Column(name = "promoter-id-card")
    private String promoterIdCardPath;
    @Column(name = "event-request-date")
    private String eventRequestDate;
    @Column(name = "is-accepted")
    private boolean isAccepted;
    @Column(name = "location-address")
    private String locationAddress;
    @Column(name = "max-customers")
    private Long maxCustomers;
    @Column(name = "location-name")
    private String locationName;
    @Column(name = "location-description")
    private String locationDescription;
    @Column(name = "event-expected-start")
    private String expectedEventStart;
    @Column(name = "event-expected-end")
    private String expectedEventEnd;
    @Column(name = "event-name")
    private String eventName;

}