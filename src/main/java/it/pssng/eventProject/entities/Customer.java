package it.pssng.eventProject.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String idCode;
    private Long phoneNumber;
    private String eMail;
    private String name;
    private int age;

    //GETTER
    public String getidCode(){
        return idCode;
    }
    public Long getPhoneNumber(){
        return phoneNumber;
    }
    public String geteMail(){
        return eMail;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    //SETTER

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
