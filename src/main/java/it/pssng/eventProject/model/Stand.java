package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "stand")
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stand-id")
    private Long standId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event-id", referencedColumnName = "event-id")
    private Event joinedEvent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist-fiscal-code", referencedColumnName = "artist-fiscal-code")
    private Artist joinedArtist;

}
