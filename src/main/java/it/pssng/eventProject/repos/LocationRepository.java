package it.pssng.eventProject.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long>{

}
