package it.pssng.eventProject.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
