package it.pssng.eventProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.pssng.eventProject.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT e FROM Event e WHERE e.eventCategory = ?1")
    List<Event> findAllEventsByCategory(String category);
    
    @Query("SELECT DISTINCT e.eventCategory FROM Event e")
    List<String> findDistinctCategories();
    

}
