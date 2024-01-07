package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Event;
import it.pssng.eventProject.repos.EventRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public List<Event> getAllEvents() {
        List<Event> fetchedEvents = eventRepository.findAll();
        return fetchedEvents;
    }

    public Event getEventById(Long id) {
        Optional<Event> fetchedEvent = eventRepository.findById(id);
        return fetchedEvent.orElse(null);
    }

    public Event saveNewEvent(Event newEventData) {
        return eventRepository.save(newEventData);
    }

    public void deleteEvent(Event data) {
        eventRepository.delete(data);
    }

    public List<Event> getAllEventsByCategory(String category) {
        return eventRepository.findAllEventsByCategory(category);
    }

    public List<String> getAllEventsCategories() {
        return eventRepository.findDistinctCategories();
    }

}
