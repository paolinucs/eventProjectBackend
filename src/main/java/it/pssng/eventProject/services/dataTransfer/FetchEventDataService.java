package it.pssng.eventProject.services.dataTransfer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.FetchEventData;
import it.pssng.eventProject.exception.EventNotFoundException;
import it.pssng.eventProject.model.Event;
import it.pssng.eventProject.services.business.EventService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FetchEventDataService {

    private final EventService eventService;

    private FetchEventData mapToDataTransfer(Event eventDataToMap) {
        FetchEventData mappedData = new FetchEventData();
        mappedData.setEventName(eventDataToMap.getEventName());
        mappedData.setEventDescription(eventDataToMap.getEventDescription());
        mappedData.setMaximumCapacity(eventDataToMap.getMaximumCapacity());
        mappedData.setEventStartDate(eventDataToMap.getEventStartDate());
        mappedData.setEventEndDate(eventDataToMap.getEventEndDate());
        mappedData.setEventCategory(eventDataToMap.getEventCategory());
        mappedData.setLocationName(eventDataToMap.getJoinedLocation().getLocationName());
        mappedData.setEventPicPath(eventDataToMap.getEventPicPath());
        mappedData.setEventRegion(eventDataToMap.getEventRegion());
        mappedData.setEventPrice(eventDataToMap.getEventPrice());
        mappedData.setPromoterNameSurname(
                eventDataToMap.getJoinedPromoter().getPromoterName() + " "
                        + eventDataToMap.getJoinedPromoter().getPromoterSurname());
        mappedData.setPromoterEmail(eventDataToMap.getJoinedPromoter().getPromoterEmail());

        return mappedData;
    }

    public FetchEventData getEventById(Long eventId) throws EventNotFoundException {
        Event fetchedEvent = eventService.getEventById(eventId);
        if (fetchedEvent == null)
            throw new EventNotFoundException();
        FetchEventData returnData = this.mapToDataTransfer(fetchedEvent);
        return returnData;
    }

    // public FetchEventData createNewEvent(FetchEventData data) throws
    // EventNotFoundException {
    // if (data == null)
    // throw new EventNotFoundException();
    // Event convertedData = eventService.convertToEvent(data);
    // return
    // eventService.convertToEventDTO(eventService.saveNewEvent(convertedData));
    // }

    // public void deleteEvent(FetchEventData data) {
    // eventService.deleteEvent(eventService.convertToEvent(data));
    // }

    public List<FetchEventData> getAllEvents() {
        List<FetchEventData> fetchedEvents = new ArrayList<>();
        List<Event> fetchedEventsRaw = eventService.getAllEvents();

        if (!fetchedEventsRaw.isEmpty()) {
            for (Event event : fetchedEventsRaw)
                fetchedEvents.add(this.mapToDataTransfer(event));

            return fetchedEvents;
        }

        return null;
    }

    public List<FetchEventData> getAllEventsByCategory(String category) {
        List<FetchEventData> fetchedEvents = new ArrayList<>();
        List<Event> fetchedEventsRaw = eventService.getAllEventsByCategory(category);

        if (!fetchedEventsRaw.isEmpty()) {
            for (Event event : fetchedEventsRaw)
                fetchedEvents.add(this.mapToDataTransfer(event));

            return fetchedEvents;
        }

        return null;
    }

}
