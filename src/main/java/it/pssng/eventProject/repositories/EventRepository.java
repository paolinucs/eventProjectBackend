package it.pssng.eventProject.repositories;

import it.pssng.eventProject.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
