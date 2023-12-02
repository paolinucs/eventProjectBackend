package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="artist_request")
public class Artist_Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long requet_ID;

    private String Artist_ID;

    private Long Stand_ID;

    private boolean is_accepted;

    public Long getRequet_ID() {
        return requet_ID;
    }
    public Long getStand_ID() {
        return Stand_ID;
    }

    public String getArtist_ID() {
        return Artist_ID;
    }

    public boolean isIs_accepted() {
        return is_accepted;
    }

    public void setRequet_ID(Long requet_ID) {
        this.requet_ID = requet_ID;
    }

    public void setArtist_ID(String artist_ID) {
        Artist_ID = artist_ID;
    }

    public void setStand_ID(Long stand_ID) {
        Stand_ID = stand_ID;
    }

    public void setIs_accepted(boolean is_accepted) {
        this.is_accepted = is_accepted;
    }
}
