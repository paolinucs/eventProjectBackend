package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;

@Entity
@Table(name = "promoter")
@Getter
@Setter
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

}