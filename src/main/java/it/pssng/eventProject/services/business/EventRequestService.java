package it.pssng.eventProject.services.business;

import it.pssng.eventProject.dto.EventRequestDTO;
import it.pssng.eventProject.model.EventRequest;
import it.pssng.eventProject.repos.EventRequestRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventRequestService {

    private final EventRequestRepository eventRequestRepository;
    private final ModelMapper modelMapper;

    public List<EventRequest> getAllEventRequests() {
        return this.eventRequestRepository.findAll();
    }

    public EventRequest getEventRequestById(Long id) {
        Optional<EventRequest> fetchedRequest = this.eventRequestRepository.findById(id);
        return fetchedRequest.orElse(null);
    }

    public EventRequest saveEventRequest(EventRequest data) {
        return eventRequestRepository.save(data);
    }

    public void deleteEventRequest(EventRequest data) {
        eventRequestRepository.delete(data);
    }

    public EventRequestDTO convEventRequestDTO(EventRequest data) {
        return modelMapper.map(data, EventRequestDTO.class);
    }

    public EventRequest convEventRequest(EventRequestDTO data) {
        return modelMapper.map(data, EventRequest.class);
    }

}
