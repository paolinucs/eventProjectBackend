package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "artist_request")
public class ArtistRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "requestID")
    private Long requestID;

    @Column(name = "artistID")
    private String artistID;

    @Column(name = "standID")
    private Long standID;

    @Column(name = "isAccepted")
    private boolean isAccepted;
}
