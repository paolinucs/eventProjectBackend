package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.EventRequest;
import it.pssng.eventProject.repositories.EventRequestRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EventRequestService {

    private final EventRequestRepository eventRequestRepository;

    public List<EventRequest> getAllEvents() {
        return this.eventRequestRepository.findAll();
    }

    public EventRequest getEventRequestById(Long id) {
        Optional<EventRequest> fetchedRequest = this.eventRequestRepository.findById(id);
        return fetchedRequest.orElse(null);
    }

}
