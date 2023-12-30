package it.pssng.eventProject.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private String reviewTitle;
    private String reviewText;
    private Long reviewRating;
    private String username;

}
