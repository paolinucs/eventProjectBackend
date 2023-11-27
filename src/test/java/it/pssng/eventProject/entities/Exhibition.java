package it.pssng.eventProject.entities;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

@Entity
@Table(name="exhibitions")
public class Exhibition {

    //Table attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long exhibitionCode;

    @NotNull
    private int numberOfWorks;
    @NotNull
    private int maximumCapacity;
    private String exhibitionTheme;
    @NotNull
    private String description;
    @NotNull
    private String location;
    @NotNull
    private String dateAndTime;

    //Getters and Setters
    public Long getExhibitionCode() {
        return exhibitionCode;
    }

    public int getNumberOfWorks() {
        return numberOfWorks;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getExhibitionTheme() {
        return exhibitionTheme;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setExhibitionCode(Long exhibitionCode) {
        this.exhibitionCode = exhibitionCode;
    }

    public void setExhibitionTheme(String exhibitionTheme) {
        this.exhibitionTheme = exhibitionTheme;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public void setNumberOfWorks(int numberOfWorks) {
        this.numberOfWorks = numberOfWorks;
    }
}
