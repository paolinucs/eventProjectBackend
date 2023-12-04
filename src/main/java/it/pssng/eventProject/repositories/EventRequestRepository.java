package it.pssng.eventProject.repositories;
import it.pssng.eventProject.entities.EventRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRequestRepository extends JpaRepository<EventRequest,Long> {
}
