package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Username")
    private String UserName;
    @Column(name = "Password")
    private String Password;
    @Column(name = "Role")
    private String Role;
}
