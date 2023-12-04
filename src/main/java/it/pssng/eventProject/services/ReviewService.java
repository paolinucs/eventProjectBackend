package it.pssng.eventProject.services;


import it.pssng.eventProject.entities.Review;
import it.pssng.eventProject.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReviewService {

        private final ReviewRepository reviewRepository;

        @Autowired
        public ReviewService(ReviewRepository reviewRepository){
            this.reviewRepository = reviewRepository;
        }

        public Review getReviewById(Long id){
            Optional<Review> fetchedReview = reviewRepository.findById(id);
            return fetchedReview.orElse(null);
        }

        public List<Review> getAllReviews(){
            List<Review> fetchedReviews = reviewRepository.findAll();
            return fetchedReviews;
        }


}
