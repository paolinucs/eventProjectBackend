package it.pssng.eventProject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review-id")
    private Long reviewId;
    @Column(name = "review-title")
    private String reviewTitle;
    @Column(name = "review-text")
    private String reviewText;
    @Column(name = "review-rating")
    private Long reviewRating;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User joinedUser;
}
