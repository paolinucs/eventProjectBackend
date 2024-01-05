package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Review;
import it.pssng.eventProject.repos.ReviewRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Review getReviewById(Long id) {
        Optional<Review> fetchedReview = reviewRepository.findById(id);
        return fetchedReview.orElse(null);
    }

    public List<Review> getAllReviews() {
        List<Review> fetchedReviews = reviewRepository.findAll();
        return fetchedReviews;
    }

}
