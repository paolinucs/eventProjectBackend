package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promoter")
@Data
public class Promoter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "promoter-id")
    private Long promoterId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter-fiscal-code", referencedColumnName = "fiscal-code")
    private User promoterFiscalCode;
    @Column(name = "promoter-name")
    private String promoterName;
    @Column(name = "promoter-birthdate")
    private String promoterBirthDate;
    @Column(name = "promoter-surname")
    private String promoterSurname;
    @Column(name = "promoter-city")
    private String promoterCity;
    @Column(name = "promoter-nationality")
    private String promoterNationality;
    @Column(name = "e-mail", unique = true)
    private String promoterEmail;


}