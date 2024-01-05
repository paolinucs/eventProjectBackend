package it.pssng.eventProject.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.EventDTO;
import it.pssng.eventProject.exception.EventNotFoundException;
import it.pssng.eventProject.services.dataTransfer.EventDtoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/events")
public class EventController {

    private final EventDtoService eventDtoService;
    private static Logger LOGGER = LoggerFactory.getLogger("EventControllerLogger");

    /*
     * Get all events in db
     */
    @GetMapping("/get_all")
    public ResponseEntity<List<EventDTO>> getAllEvents() {
        List<EventDTO> fetchedEvents = eventDtoService.getAllEvents();
        if (!fetchedEvents.isEmpty()) {
            LOGGER.info("/api/events/get_all ended succesfully");
            return ResponseEntity.ok(fetchedEvents);
        }

        LOGGER.info("/api/events/get_all ended succesfully");
        return ResponseEntity.noContent().build();
    }

    /*
     * Get a list of events filtered by category
     */
    @GetMapping("/by_category/{category}")
    public ResponseEntity<List<EventDTO>> getAllEventsByCategory(@PathVariable String category) {
        List<EventDTO> fetchedEvents = eventDtoService.getAllEventsByCategory(category);
        if (!fetchedEvents.isEmpty()) {
            LOGGER.info("Operation /api/events/by_category ended succesfully");
            return ResponseEntity.ok(fetchedEvents);
        }

        LOGGER.info("Operation /api/events/by_category cannot be ended succesfully because of no Content");
        return ResponseEntity.noContent().build();
    }

    /*
     * Get a single event by id
     */
    @GetMapping("/by_id({id})")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO fetchedEvent = eventDtoService.getEventById(id);
        if (fetchedEvent != null) {
            LOGGER.info("Operation /api/events/by_id ended succesfully");
            return ResponseEntity.ok(fetchedEvent);
        }

        LOGGER.info("Operation /api/events/by_category ended succesfully");
        return ResponseEntity.noContent().build();
    }

    /*
     * Save a new Event
     */
    @PostMapping("/new")
    public ResponseEntity<EventDTO> saveNewEvent(EventDTO data) throws EventNotFoundException {
        try {
            EventDTO savedEventData = eventDtoService.createNewEvent(data);
            LOGGER.info("/api/events/by_category/new ended succesfully");
            return ResponseEntity.ok(savedEventData);

        } catch (EventNotFoundException exc) {
            LOGGER.info("Operation /api/events/by_category/new cannot be ended because of invalid json input\n" + exc);
            return ResponseEntity.badRequest().build();
        }
    }

    /*
     * Delete existing event
     */
    @PostMapping("/delete")
    public void deleteExistingEvent(EventDTO data) {
        try {
            eventDtoService.deleteEvent(data);
            LOGGER.info("Operation /api/events/by_category/delete ended succesfully");
            ResponseEntity.ok().build();
        } catch (Exception exc) {
            LOGGER.info("Operation /api/events/by_category/delete cannot be ended succesfully\n" + exc);
            ResponseEntity.internalServerError().build();
        }
    }

}
