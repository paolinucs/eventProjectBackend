package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promoter")
@Data
public class Promoter {

    @Id
    @Column(name = "promoter-fiscal-code")
    private String promoterFiscalCode;
    @Column(name = "promoter-name")
    private String promoterName;
    @Column(name = "promoter-surname")
    private String promoterSurname;
    @Column(name = "promoter-email", unique = true)
    private String promoterEmailAddress;
    @Column(name = "promoter-phone")
    private String promoterPhoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User joinedUser;

}