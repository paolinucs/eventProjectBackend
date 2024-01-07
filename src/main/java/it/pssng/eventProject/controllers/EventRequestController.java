package it.pssng.eventProject.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.EventRequestDTO;
import it.pssng.eventProject.services.dataTransfer.EventRequestDtoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/event_requests")
@AllArgsConstructor
public class EventRequestController {

    private final EventRequestDtoService eventRequestDtoService;
    private static Logger LOGGER = LoggerFactory.getLogger("EventRequestControllerLogger");

    /*
     * Get All event requests
     */
    // @GetMapping("/get_all")
    // public ResponseEntity<List<EventRequestDTO>> getAllEventRequests() {
    //     List<EventRequestDTO> fetchedEventRequests = eventRequestDtoService.getAllEventRequests();
    //     if (!fetchedEventRequests.isEmpty()) {
    //         LOGGER.info("/api/event_requests/get_all ended succesfully");
    //         return ResponseEntity.ok(fetchedEventRequests);
    //     }

    //     LOGGER.info("/api/event_requests/get_all cannot be ended succesfully: cannot retrieve events!");
    //     return ResponseEntity.noContent().build();
    // }

    // /*
    //  * Get event request by id
    //  */
    // @GetMapping("/by_id({id})")
    // public ResponseEntity<EventRequestDTO> getEventRequestById(@PathVariable Long id) {
    //     EventRequestDTO fetchedEventRequest = eventRequestDtoService.getEventRequestById(id);
    //     if (fetchedEventRequest != null) {
    //         LOGGER.info("Operation /api/event_requests/by_id ended succesfully");
    //         return ResponseEntity.ok(fetchedEventRequest);
    //     }

    //     LOGGER.info("Operation /api/event_requests/by_id cannot be ended succesfully: event not found!");
    //     return ResponseEntity.noContent().build();
    // }

    /*
     * Save a new Event Request
     */
    @PostMapping("/new")
    public ResponseEntity<EventRequestDTO> saveNewEventRequest(@RequestBody EventRequestDTO data) throws Exception {
        try {
            EventRequestDTO savedEventRequestData = eventRequestDtoService.saveNewEventRequest(data);
            LOGGER.info("/api/event_request/new ended succesfully");
            return ResponseEntity.ok(savedEventRequestData);

        } catch (Exception exc) {
            LOGGER.info("Operation /api/event_request/new cannot be ended because of invalid json input\n" + exc);
            return ResponseEntity.badRequest().build();
        }
    }

    /*
     * Delete existing event request
     */
    @PostMapping("/delete")
    public void deleteExistingEventRequest(EventRequestDTO data) {
        try {
            eventRequestDtoService.deleteEventRequest(data);
            LOGGER.info("Operation /api/event_requests/delete ended succesfully");
            ResponseEntity.ok().build();
        } catch (Exception exc) {
            LOGGER.info("Operation /api/event_requests/delete cannot be ended succesfully\n" + exc);
            ResponseEntity.internalServerError().build();
        }
    }

}
