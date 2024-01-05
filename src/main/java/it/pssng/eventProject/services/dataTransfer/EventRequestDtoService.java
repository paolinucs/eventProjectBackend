package it.pssng.eventProject.services.dataTransfer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.EventRequestDTO;
import it.pssng.eventProject.model.EventRequest;
import it.pssng.eventProject.services.business.EventRequestService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventRequestDtoService {

    private final EventRequestService eventRequestService;

    public EventRequestDTO saveNewEventRequest(EventRequestDTO data) {
        try {

            data.setPermissionDocumentPath(data.getEventRequestId() + "_" + data.getPermissionDocumentPath());
            data.setPromoterIdCardPath(data.getEventRequestId() + "_" + data.getPromoterIdCardPath());

            EventRequest savedEventRequest = eventRequestService
                    .saveEventRequest(eventRequestService.convEventRequest(data));
            return eventRequestService.convEventRequestDTO(savedEventRequest);
        } catch (Exception exc) {
            throw new RuntimeException();
        }
    }

    public void deleteEventRequest(EventRequestDTO data) {
        try {
            eventRequestService.deleteEventRequest(eventRequestService.convEventRequest(data));
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
            fetchedEvents.add(eventRequestService.convEventRequestDTO(ev));
        return fetchedEvents;
    }

    public EventRequestDTO getEventRequestById(Long id) {
        return eventRequestService.convEventRequestDTO(eventRequestService.getEventRequestById(id));
    }

}
