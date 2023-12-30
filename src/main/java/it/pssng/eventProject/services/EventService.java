package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Event;
import it.pssng.eventProject.repositories.EventRepository;
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

}
