package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="artworks")
public class ArtWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ArtworksID")
    private long ArtWorks_ID;
    @Column(name = "ArtworksName")
    private String ArtWorks_Name;
    @Column(name = "ArtworksDescription")
    private String ArtWorks_Description;
    @Column(name = "ArtworksDate")
    private String ArtWorks_Date;
    @Column(name = "StandID")
    private String Stand_Id;

    public long getArtWorks_ID() {
        return ArtWorks_ID;
    }

    public String getArtWorks_Name() {
        return ArtWorks_Name;
    }

    public String getArtWorks_Description() {
        return ArtWorks_Description;
    }

    public String getArtWorks_Date() {
        return ArtWorks_Date;
    }

    public String getStand_Id() {
        return Stand_Id;
    }

    public void setArtWorks_ID(long artWorks_ID) {
        ArtWorks_ID = artWorks_ID;
    }

    public void setArtWorks_Name(String artWorks_Name) {
        ArtWorks_Name = artWorks_Name;
    }

    public void setArtWorks_Description(String artWorks_Description) {
        ArtWorks_Description = artWorks_Description;
    }

    public void setArtWorks_Date(String artWorks_Date) {
        ArtWorks_Date = artWorks_Date;
    }

    public void setStand_Id(String stand_Id) {
        Stand_Id = stand_Id;
    }
}
