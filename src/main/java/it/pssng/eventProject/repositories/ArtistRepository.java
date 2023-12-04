package it.pssng.eventProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import it.pssng.eventProject.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist, String> {
}
