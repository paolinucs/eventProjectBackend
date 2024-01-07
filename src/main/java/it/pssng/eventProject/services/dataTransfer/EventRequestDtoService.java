package it.pssng.eventProject.services.dataTransfer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.EventRequestDTO;
import it.pssng.eventProject.exception.EventNotFoundException;
import it.pssng.eventProject.model.Event;
import it.pssng.eventProject.model.EventRequest;
import it.pssng.eventProject.model.Location;
import it.pssng.eventProject.repos.LocationRepository;
import it.pssng.eventProject.services.business.EventRequestService;
import it.pssng.eventProject.services.business.EventService;
import it.pssng.eventProject.services.mail.RequestMailService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventRequestDtoService {

    private final EventRequestService eventRequestService;
    private final RequestMailService requestMailService;
    private final LocationRepository locationRepository;
    private final EventService eventService;

    private EventRequest mapToBusiness(EventRequestDTO modelToMap) {
        EventRequest mappedEvent = new EventRequest();
        mappedEvent.setEventName(modelToMap.getEventName());
        mappedEvent.setEventRequestDate(modelToMap.getEventRequestDate());
        mappedEvent.setEventRequestId(modelToMap.getEventRequestId());
        mappedEvent.setExpectedEventEnd(modelToMap.getExpectedEventEnd());
        mappedEvent.setExpectedEventStart(modelToMap.getExpectedEventStart());
        mappedEvent.setEventName(modelToMap.getEventName());
        mappedEvent.setPermissionDocumentPath(modelToMap.getPermissionDocumentPath());
        mappedEvent.setPromoterIdCardPath(modelToMap.getPromoterIdCardPath());
        mappedEvent.setLocationAddress(modelToMap.getLocationAddress());
        mappedEvent.setMaxCustomers(modelToMap.getMaxCustomers());
        mappedEvent.setLocationName(modelToMap.getLocationName());
        mappedEvent.setLocationDescription(modelToMap.getLocationDescription());

        return mappedEvent;
    }

    private EventRequestDTO mapToDataTransfer(EventRequest modelToMap) {
        EventRequestDTO mappedEvent = new EventRequestDTO();
        mappedEvent.setEventName(modelToMap.getEventName());
        mappedEvent.setEventRequestDate(modelToMap.getEventRequestDate());
        mappedEvent.setEventRequestId(modelToMap.getEventRequestId());
        mappedEvent.setExpectedEventEnd(modelToMap.getExpectedEventEnd());
        mappedEvent.setExpectedEventStart(modelToMap.getExpectedEventStart());
        mappedEvent.setEventName(modelToMap.getEventName());
        mappedEvent.setPermissionDocumentPath(modelToMap.getPermissionDocumentPath());
        mappedEvent.setPromoterIdCardPath(modelToMap.getPromoterIdCardPath());
        mappedEvent.setLocationAddress(modelToMap.getLocationAddress());
        mappedEvent.setMaxCustomers(modelToMap.getMaxCustomers());
        mappedEvent.setLocationName(modelToMap.getLocationName());
        mappedEvent.setLocationDescription(modelToMap.getLocationDescription());

        return mappedEvent;
    }

    public EventRequestDTO saveNewEventRequest(EventRequestDTO data) {
        try {

            data.setPermissionDocumentPath(data.getEventRequestId() + "_" + data.getPermissionDocumentPath());
            data.setPromoterIdCardPath(data.getEventRequestId() + "_" + data.getPromoterIdCardPath());

            EventRequest savedEventRequest = eventRequestService
                    .saveEventRequest(mapToBusiness(data));

            requestMailService.sendEventRequestMail(data);

            return this.mapToDataTransfer(savedEventRequest);
        } catch (Exception exc) {
            throw new RuntimeException();
        }
    }

    public void deleteEventRequest(EventRequestDTO data) {
        try {
            eventRequestService.deleteEventRequest(mapToBusiness(data));
        } catch (Exception exc) {
            throw new RuntimeException();
        }
    }

    public List<EventRequestDTO> getAllEventRequests() {
        List<EventRequest> fetchedEventsRaw = eventRequestService.getAllEventRequests();
        List<EventRequestDTO> fetchedEvents = new ArrayList<>();

        if (fetchedEventsRaw.isEmpty())
            return null;
        for (EventRequest ev : fetchedEventsRaw)
            fetchedEvents.add(this.mapToDataTransfer(ev));
        return fetchedEvents;
    }

    public EventRequestDTO getEventRequestById(Long id) {
        EventRequest fetchedEventRequest = eventRequestService.getEventRequestById(id);
        return this.mapToDataTransfer(fetchedEventRequest);
    }

    public void acceptEventRequest(Long eventRequestId) throws EventNotFoundException {

        EventRequest fetchedEventRequest = eventRequestService.getEventRequestById(eventRequestId);
        if (fetchedEventRequest == null)
            throw new EventNotFoundException();

        Event newEvent = new Event();
        Location newLocation = new Location();

        if (locationRepository
                .findByNameAndAddress(fetchedEventRequest.getLocationName(), fetchedEventRequest.getLocationAddress())
                .isPresent()) {
            newLocation = locationRepository.findByNameAndAddress(fetchedEventRequest.getLocationName(),
                    fetchedEventRequest.getLocationAddress()).get();
        } else {
            newLocation.setLocationName(fetchedEventRequest.getLocationName());
            newLocation.setLocationAddress(fetchedEventRequest.getLocationAddress());
            newLocation.setLocationDescription(fetchedEventRequest.getLocationDescription());

            locationRepository.save(newLocation);
        }

        newEvent.setEventName(fetchedEventRequest.getEventName());
        newEvent.setEventDescription(fetchedEventRequest.getEventDescription());
        newEvent.setEventStartDate(fetchedEventRequest.getExpectedEventStart());
        newEvent.setEventEndDate(fetchedEventRequest.getExpectedEventEnd());
        newEvent.setEventRegion(fetchedEventRequest.getEventRegion());
        newEvent.setEventPicPath(fetchedEventRequest.getEventPicPath());
        newEvent.setEventPrice(fetchedEventRequest.getEventPrice());
        newEvent.setMaximumCapacity(fetchedEventRequest.getMaxCustomers());
        newEvent.setEventCategory(fetchedEventRequest.getEventCategory());
        newEvent.setJoinedLocation(newLocation);
        newEvent.setJoinedPromoter(fetchedEventRequest.getJoinedPromoter());

        eventRequestService.acceptRequest(eventRequestId);

        eventService.saveNewEvent(newEvent);

    }

    public void declineEventRequest(Long eventRequestId) {
        eventRequestService.declineRequest(eventRequestId);
    }

}
