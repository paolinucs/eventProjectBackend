package it.pssng.eventProject.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long reviewId;
    @Column(name = "review_title")
    private String reviewTitle;
    @Column(name = "review_text")
    private String reviewText;
    @Column(name = "review_rating")
    private Long reviewRating;
    @Column(name = "username")
    private String username;
}
