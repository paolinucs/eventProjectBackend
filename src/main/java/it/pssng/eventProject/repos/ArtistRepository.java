package it.pssng.eventProject.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
