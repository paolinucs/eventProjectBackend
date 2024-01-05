package it.pssng.eventProject.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.EventRequest;

public interface EventRequestRepository extends JpaRepository<EventRequest,Long> {
}
