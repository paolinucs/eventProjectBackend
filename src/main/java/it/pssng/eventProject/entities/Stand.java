package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="stand")
public class Stand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long standCode;

    private String artWorksName;

    private String exhibitionName;

    private String Name;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName() {
        return Name;
    }

    public Long getStandCode() {
        return standCode;
    }

    public String getArtWorksName() {
        return artWorksName;
    }

    public String getExhibitionName() {
        return exhibitionName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setArtWorksName(String artWorksName) {
        this.artWorksName = artWorksName;
    }

    public void setStandCode(Long standCode) {
        this.standCode = standCode;
    }

    public void setExhibitionName(String exhibitionName) {
        this.exhibitionName = exhibitionName;
    }
}
