package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String FiscalCodeAuthor;

    private String ResidentialAddress;

    private String Email;

    private int PhoneNumber;

    private int Age;

    public String getFiscalCodeAuthor() {
        return FiscalCodeAuthor;
    }

    public String getResidentialAddress() {
        return ResidentialAddress;
    }

    public String getEmail() {
        return Email;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setFiscalCodeAuthor(String fiscalCodeAuthor) {
        FiscalCodeAuthor = fiscalCodeAuthor;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setResidentialAddress(String residentialAddress) {
        ResidentialAddress = residentialAddress;
    }

}
