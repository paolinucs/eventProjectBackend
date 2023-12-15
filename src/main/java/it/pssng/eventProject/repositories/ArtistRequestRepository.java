package it.pssng.eventProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import it.pssng.eventProject.entities.ArtistRequest;

public interface ArtistRequestRepository extends JpaRepository<ArtistRequest, Long> {
}
