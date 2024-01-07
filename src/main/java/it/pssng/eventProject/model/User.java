package it.pssng.eventProject.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user-data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user-id")
    private Long userId;
    @Column(name = "fiscal-code", unique = true)
    private String fiscalCode;
    @Column(name = "password")
    private String Password;
    @Column(name = "role")
    private String Role;
}
