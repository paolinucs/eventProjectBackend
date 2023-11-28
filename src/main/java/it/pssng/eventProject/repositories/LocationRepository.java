package it.pssng.eventProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import it.pssng.eventProject.entities.Location;

public interface LocationRepository extends JpaRepository<Location,Long>{

}
