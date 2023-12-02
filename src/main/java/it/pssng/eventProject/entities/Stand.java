package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="stand")
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Stand_ID;

    private Long Event_ID;

    private Long Artist_ID;

    private boolean is_taken;

    public Long getStand_ID() {
        return Stand_ID;
    }

    public Long getEvent_ID() {
        return Event_ID;
    }

    public Long getArtist_ID() {
        return Artist_ID;
    }

    public boolean isIs_taken() {
        return is_taken;
    }

    public void setStand_ID(Long stand_ID) {
        Stand_ID = stand_ID;
    }

    public void setEvent_ID(Long event_ID) {
        Event_ID = event_ID;
    }

    public void setArtist_ID(Long artist_ID) {
        Artist_ID = artist_ID;
    }

    public void setIs_taken(boolean is_taken) {
        this.is_taken = is_taken;
    }
}
