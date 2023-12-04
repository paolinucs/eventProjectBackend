package it.pssng.eventProject.entities;
import jakarta.persistence.*;

@Entity
@Table
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
    private short reviewRating;
    @Column(name = "username")
    private String username;

    //getters and setters


    public Long getReviewId() {
        return reviewId;
    }

    public short getReviewRating() {
        return reviewRating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getUsername() {
        return username;
    }

    public void setReviewRating(short reviewRating) {
        this.reviewRating = reviewRating;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
