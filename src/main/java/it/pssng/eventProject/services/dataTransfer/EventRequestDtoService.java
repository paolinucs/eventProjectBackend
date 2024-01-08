package it.pssng.eventProject.services.dataTransfer;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.EventRequestDTO;
import it.pssng.eventProject.exception.EventNotFoundException;
import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.model.Event;
import it.pssng.eventProject.model.EventRequest;
import it.pssng.eventProject.model.Location;
import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.repos.LocationRepository;
import it.pssng.eventProject.services.business.EventRequestService;
import it.pssng.eventProject.services.business.EventService;
import it.pssng.eventProject.services.business.PromoterService;
import it.pssng.eventProject.services.business.UserService;
import it.pssng.eventProject.services.mail.RequestMailService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventRequestDtoService {

    private final EventRequestService eventRequestService;
    private final RequestMailService requestMailService;
    private final LocationRepository locationRepository;
    private final EventService eventService;
    private final UserService userService;
    private final PromoterService promoterService;

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
        mappedEvent.setEventDescription(modelToMap.getEventDescription());
        mappedEvent.setEventRegion(modelToMap.getEventRegion());
        mappedEvent.setEventPicPath(modelToMap.getEventPicPath());
        mappedEvent.setEventCategory(modelToMap.getEventCategory());
        mappedEvent.setEventPrice(modelToMap.getEventPrice());

        Optional<User> fetchedUser = userService.findUserByFiscalCode(modelToMap.getPromoterFiscalCode());
        Optional<Promoter> fetchedPromoter = promoterService.findPromoterByFiscalCode(fetchedUser.get());

        mappedEvent.setJoinedPromoter(fetchedPromoter.get());

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
        mappedEvent.setEventDescription(modelToMap.getEventDescription());
        mappedEvent.setEventRegion(modelToMap.getEventRegion());
        mappedEvent.setEventPicPath(modelToMap.getEventPicPath());
        mappedEvent.setEventCategory(modelToMap.getEventCategory());
        mappedEvent.setEventPrice(modelToMap.getEventPrice());

        return mappedEvent;
    }

    public EventRequestDTO saveNewEventRequest(EventRequestDTO data) throws UserNotFoundException {

            EventRequest savedEventRequest = eventRequestService
                    .saveEventRequest(mapToBusiness(data));

            requestMailService.sendEventRequestMail(data);

            return this.mapToDataTransfer(savedEventRequest);
        
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
