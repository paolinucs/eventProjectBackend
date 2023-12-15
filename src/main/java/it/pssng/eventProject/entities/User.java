package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Username")
    private String UserName;
    @Column(name = "Password")
    private String Password;
    @Column(name = "Role")
    private String Role;
}
