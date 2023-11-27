package it.pssng.eventProject.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tickets")
public class Ticket {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketCode;
    private Long exhibitionCode;
    private String idCode;
    private String purchaseDate;
    private String exhibitionDate;
    private Float price;

    //GETTERS
    public Long getTicketCode() {
        return ticketCode;
    }
    public Long getExhibitionCode(){
        return  exhibitionCode;
    }
    public String getIdCode(){
        return idCode;
    }
    public String getPurchaseDate() {
        return purchaseDate;
    }
    public String getExhibitionDate() {
        return exhibitionDate;
    }

    public Float getPrice() {
        return price;
    }

    //SETTERS
    public void setTicketCode(Long ticketCode) {
        this.ticketCode = ticketCode;
    }
    public void setExhibitionCode(Long exhibitionCode) {
        this.exhibitionCode = exhibitionCode;
    }
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    public void setExhibitionDate(String exhibitionDate) {
        this.exhibitionDate = exhibitionDate;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
}
