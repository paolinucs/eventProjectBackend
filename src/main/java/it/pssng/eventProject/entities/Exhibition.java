package it.pssng.eventProject.entities;

import jakarta.persistence.*;

@Entity
@Table(name="exhibitions")
public class Exhibition {

    //Table attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long exhibitionCode;
    private int numberOfWorks;

    private int maximumCapacity;
    private String exhibitionTheme;
    private String description;
    private String location;
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
