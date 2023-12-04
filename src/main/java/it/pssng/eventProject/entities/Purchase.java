package it.pssng.eventProject.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Purchase_id")
    public Long purchaseId;
    @Column(name = "Purchase_date")
    public String purchaseDate;
    @Column(name = "Purchase_amount")
    public Double purchaseAmount;
    @Column(name = "Customer_id")
    public String customerId;
    @Column(name = "Ticket_id")
    public Long ticketId;

    //GETTERS
    public Long getPurchaseId(){return purchaseId; }
    public String getPurchaseDate(){return purchaseDate; }
    public Double getPurchaseAmount(){return purchaseAmount; }
    public String getCustomerId(){return customerId; }
    public Long getTicketId(){return  ticketId; }

    //SETTERS
    public void setPurchaseId(Long purchaseId){this.purchaseId = purchaseId; }
    public void setPurchaseDate(String purchaseDate){this.purchaseDate = purchaseDate; }
    public void setPurchaseAmount(Double purchaseAmount){this.purchaseAmount = purchaseAmount; }
    public void setCustomerId(String customerId){this.customerId = customerId; }
    public void setTicketId(Long ticketId){this.ticketId = ticketId; }


}
