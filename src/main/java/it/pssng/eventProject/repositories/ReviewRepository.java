package it.pssng.eventProject.repositories;
import it.pssng.eventProject.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
