package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="artworks")
public class ArtWorks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long ArtWorksCode;

    private String Name;

    private String Description;

    private String Date;

    private String FiscalCode;


    public long getArtWorksCode() {
        return ArtWorksCode;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getDate() {
        return Date;
    }

    public void setFiscalCode(String fiscalCode) {
        FiscalCode = fiscalCode;
    }

    public void setArtWorksCode(long artWorksCode) {
        ArtWorksCode = artWorksCode;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setName(String name) {
        Name = name;
    }

}
