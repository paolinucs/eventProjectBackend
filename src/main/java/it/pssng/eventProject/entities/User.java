package it.pssng.eventProject.entities;
import jakarta.persistence.*;
@Entity

@Table(name="user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String UserName;

    private String Password;

    private String Role;

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getRole() {
        return Role;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRole(String role) {
        Role = role;
    }
}
