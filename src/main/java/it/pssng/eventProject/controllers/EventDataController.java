package it.pssng.eventProject.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.FetchEventData;
import it.pssng.eventProject.services.business.EventService;
import it.pssng.eventProject.services.dataTransfer.FetchEventDataService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/events")
public class EventDataController {

    private final FetchEventDataService eventDtoService;
    private final EventService eventService;
    private static Logger LOGGER = LoggerFactory.getLogger("EventControllerLogger");

    /*
     * Get all events in db
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/get_all")
    public ResponseEntity<List<FetchEventData>> getAllEvents() {
        List<FetchEventData> fetchedEvents = eventDtoService.getAllEvents();
        return ResponseEntity.ok(fetchedEvents);
    }

    /*
     * Get a list of events filtered by category
     */
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/by_category/{category}")
    public ResponseEntity<List<FetchEventData>> getAllEventsByCategory(@PathVariable String category) {
        List<FetchEventData> fetchedEvents = eventDtoService.getAllEventsByCategory(category);
        if (!fetchedEvents.isEmpty()) {
            LOGGER.info("Operation /api/events/by_category ended succesfully");
            return ResponseEntity.ok(fetchedEvents);
        }

        LOGGER.info("Operation /api/events/by_category cannot be ended succesfully because of no Content");
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/all_categories")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categories = eventService.getAllEventsCategories();
        if (categories.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok().build();
    }

    /*
     * Get a single event by id
     */
    // @GetMapping("/by_id({id})")
    // public ResponseEntity<FetchEventData> getEventById(@PathVariable Long id) {
    // FetchEventData fetchedEvent = eventDtoService.getEventById(id);
    // if (fetchedEvent != null) {
    // LOGGER.info("Operation /api/events/by_id ended succesfully");
    // return ResponseEntity.ok(fetchedEvent);
    // }

    // LOGGER.info("Operation /api/events/by_id ended succesfully");
    // return ResponseEntity.noContent().build();
    // }

    // /*
    // * Save a new Event
    // */
    // @PostMapping("/new")
    // public ResponseEntity<FetchEventData> saveNewEvent(FetchEventData data)
    // throws EventNotFoundException {
    // try {
    // FetchEventData savedEventData = eventDtoService.createNewEvent(data);
    // LOGGER.info("/api/by_category/new ended succesfully");
    // return ResponseEntity.ok(savedEventData);

    // } catch (EventNotFoundException exc) {
    // LOGGER.info("Operation /api/by_category/new cannot be ended because of
    // invalid json input\n" + exc);
    // return ResponseEntity.badRequest().build();
    // }
    // }

    /*
     * Delete existing event
     */
    // @PostMapping("/delete")
    // public void deleteExistingEvent(FetchEventData data) {
    // try {
    // eventDtoService.deleteEvent(data);
    // LOGGER.info("Operation /api/events/delete ended succesfully");
    // ResponseEntity.ok().build();
    // } catch (Exception exc) {
    // LOGGER.info("Operation /api/events/delete cannot be ended succesfully\n" +
    // exc);
    // ResponseEntity.internalServerError().build();
    // }
    // }

}
