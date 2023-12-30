package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artist-fiscal-code")
    private String artistFiscalCode;

    @Column(name = "artist-name")
    private String artistName;

    @Column(name = "artist-surname")
    private String artistSurname;

    @Column(name = "artist-email-address")
    private String artistEmailAddress;

    @Column(name = "artist-phone-number")
    private String phoneNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User joinedUser;
}
