package it.pssng.eventProject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.pssng.eventProject.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT l FROM Location l WHERE l.locationName = :nome AND l.locationAddress = :indirizzo")
    Optional<Location> findByNameAndAddress(@Param("nome") String locationName, @Param("indirizzo") String locationAddress);

}
