package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "artist_request")
public class ArtistRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request-id")
    private Long requestID;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist-fiscal-code", referencedColumnName = "artist-fiscal-code")
    private Artist joinedArtist;

    @Column(name = "is-accepted")
    private boolean isAccepted;
}
