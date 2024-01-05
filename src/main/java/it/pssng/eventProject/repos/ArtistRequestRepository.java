package it.pssng.eventProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.ArtistRequest;

public interface ArtistRequestRepository extends JpaRepository<ArtistRequest, Long> {
}
