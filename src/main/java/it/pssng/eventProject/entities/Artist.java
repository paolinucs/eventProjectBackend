package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "artistFiscalCode")
    private String artistFiscalCode;

    @Column(name = "artistName")
    private String artistName;

    @Column(name = "artistSurname")
    private String artistSurname;

    @Column(name = "artistEmailAddress")
    private String artistEmailAddress;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "artistUserName")
    private String artistUserName;
}
