package it.pssng.eventProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.pssng.eventProject.model.Event;

public interface EventRepository extends JpaRepository<Event,Long> {

    @Query(value="SELECT * FROM Event WHERE Event.eventCategory = ?1")
    public List<Event> findAllEventsByCategory(String category);
}
