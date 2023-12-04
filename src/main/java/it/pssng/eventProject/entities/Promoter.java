package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "promoter")
public class Promoter {

    @Id
    @Column(name = "fiscal_code")
    private String promoterFiscalCode;
    @Column(name = "name")
    private String promoterName;
    @Column(name = "surname")
    private String promoterSurname;
    @Column(name = "email")
    private String promoterEmailAddress;
    @Column(name = "phone")
    private String promoterPhoneNumber;
    @Column(name = "username")
    private String promoterUsername;

    //getters and setters

    public String getPromoterFiscalCode(){
        return this.promoterFiscalCode;
    }

    public String getPromoterName(){
        return this.promoterName;
    }

    public String getPromoterSurname(){
        return this.promoterSurname;
    }

    public String getPromoterEmailAddress(){
        return this.promoterEmailAddress;
    }

    public String getPromoterPhoneNumber(){
        return this.promoterPhoneNumber;
    }

    public String getPromoterUsername(){
        return this.promoterUsername;
    }

    public void setPromoterFiscalCode(String promoterFiscalCode) {
        this.promoterFiscalCode = promoterFiscalCode;
    }

    public void setPromoterName(String promoterName) {
        this.promoterName = promoterName;
    }

    public void setPromoterSurname(String promoterSurname) {
        this.promoterSurname = promoterSurname;
    }

    public void setPromoterPhoneNumber(String promoterPhoneNumber) {
        this.promoterPhoneNumber = promoterPhoneNumber;
    }

    public void setPromoterEmailAddress(String promoterEmailAddress) {
        this.promoterEmailAddress = promoterEmailAddress;
    }

    public void setPromoterUsername(String promoterUsername) {
        this.promoterUsername = promoterUsername;
    }
}
