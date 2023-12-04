package it.pssng.eventProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import it.pssng.eventProject.entities.Artist_Request;
public interface ArtistRequestRepository extends JpaRepository<Artist_Request, Long>{
}
