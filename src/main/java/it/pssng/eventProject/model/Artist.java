package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artist-id")
    private Long artistId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="artist-fiscal-code", referencedColumnName = "fiscal-code")
    private User artistFiscalCode;

    @Column(name = "artist-name")
    private String artistName;

    @Column(name = "artist-surname")
    private String artistSurname;

    @Column(name = "artist-email-address")
    private String artistEmailAddress;

    @Column(name = "artist-phone-number")
    private String phoneNumber;
}
