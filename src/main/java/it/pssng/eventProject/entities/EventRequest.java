package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "event_request")
@Getter
@Setter
public class EventRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Long eventRequestId;
    @Column(name = "promoter_id")
    private Long promoterId;
    @Column(name = "location_id")
    private Long locationId;
    @Column(name = "permission_document")
    private String permissionDocumentURL;
    @Column(name = "promoter_id_card")
    private String promoterIdCardURL;
    @Column(name = "event_request_date")
    private String eventRequestDate;
    @Column(name = "is_accepted")
    private boolean isAccepted;

}