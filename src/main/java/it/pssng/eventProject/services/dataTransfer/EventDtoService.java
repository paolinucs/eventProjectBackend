package it.pssng.eventProject.services.dataTransfer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.EventDTO;
import it.pssng.eventProject.exception.EventNotFoundException;
import it.pssng.eventProject.model.Event;
import it.pssng.eventProject.services.business.EventService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventDtoService {

    private final EventService eventService;

    public EventDTO getEventById(Long eventId) {
        Event fetchedEvent = eventService.getEventById(eventId);
        return eventService.convertToEventDTO(fetchedEvent);
    }

    public EventDTO createNewEvent(EventDTO data) throws EventNotFoundException {
        if (data == null)
            throw new EventNotFoundException();
        Event convertedData = eventService.convertToEvent(data);
        return eventService.convertToEventDTO(eventService.saveNewEvent(convertedData));
    }

    public void deleteEvent(EventDTO data) {
        eventService.deleteEvent(eventService.convertToEvent(data));
    }

    public List<EventDTO> getAllEvents() {
        List<EventDTO> fetchedEvents = new ArrayList<>();
        List<Event> fetchedEventsRaw = eventService.getAllEvents();

        if (!fetchedEventsRaw.isEmpty()) {
            for (Event event : fetchedEventsRaw)
                fetchedEvents.add(eventService.convertToEventDTO(event));

            return fetchedEvents;
        }

        return null;
    }

    public List<EventDTO> getAllEventsByCategory(String category) {
        List<EventDTO> fetchedEvents = new ArrayList<>();
        List<Event> fetchedEventsRaw = eventService.getAllEventsByCategory(category);

        if (!fetchedEventsRaw.isEmpty()) {
            for (Event event : fetchedEventsRaw)
                fetchedEvents.add(eventService.convertToEventDTO(event));

            return fetchedEvents;
        }

        return null;
    }

}
