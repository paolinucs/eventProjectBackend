package it.pssng.eventProject.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Fiscal_code")
    private String fiscalCode;
    @Column(name = "Customer_name")
    private String customerName;
    @Column(name = "Customer_surname")
    private String customerSurname;
    @Column(name = "Customer_email")
    private String customerEmail;
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "Customer_username")
    private String customerUsername;

    //GETTER
    public String getFiscalCode(){
        return fiscalCode;
    }
    public String getCustomerName(){
        return customerName;
    }
    public String getCustomerSurname(){
        return customerSurname;
    }
    public String getCustomerEmail(){
        return customerEmail;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getCustomerUsername(){return customerUsername; }

    //SETTER

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setCustomerUsername(String customerUsername) {this.customerUsername = customerUsername; }
}
