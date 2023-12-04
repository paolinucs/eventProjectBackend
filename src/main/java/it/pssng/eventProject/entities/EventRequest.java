package it.pssng.eventProject.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "event_request")
public class EventRequest {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
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

    //getters and setters

    public Long getEventRequestId(){
        return this.eventRequestId;
    }

    public Long getPromoterId(){
        return this.promoterId;
    }

    public Long getLocationId(){
        return this.locationId;
    }

    public String getPermissionDocumentURL(){
        return this.permissionDocumentURL;
    }

    public String getPromoterIdCardURL(){
        return this.promoterIdCardURL;
    }

    public String getEventRequestDate(){
        return this.eventRequestDate;
    }

    public void setEventRequestId(Long id){
        this.eventRequestId = id;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public void setEventRequestDate(String eventRequestDate) {
        this.eventRequestDate = eventRequestDate;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public void setPermissionDocumentURL(String permissionDocumentURL) {
        this.permissionDocumentURL = permissionDocumentURL;
    }

    public void setPromoterId(Long promoterId) {
        this.promoterId = promoterId;
    }

    public void setPromoterIdCardURL(String promoterIdCardURL) {
        this.promoterIdCardURL = promoterIdCardURL;
    }
}
