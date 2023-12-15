package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="stand")
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StandID")
    private Long standID;
    @Column(name = "EventID")
    private Long eventID;
    @Column(name = "ArtistID")
    private Long artistID;
    @Column(name = "isTaken")
    private boolean isTaken;
}
