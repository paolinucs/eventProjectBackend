package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Event;
import it.pssng.eventProject.dto.EventDTO;
import it.pssng.eventProject.repos.EventRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

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

    public EventDTO convertToEventDTO(Event rawData) {
        return modelMapper.map(rawData, EventDTO.class);
    }

    public Event convertToEvent(EventDTO rawDto) {
        return modelMapper.map(rawDto, Event.class);
    }

}
