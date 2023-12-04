package it.pssng.eventProject.services;
import it.pssng.eventProject.entities.EventRequest;
import it.pssng.eventProject.repositories.EventRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventRequestService {

    private final EventRequestRepository eventRequestRepository;

    @Autowired
    public EventRequestService(EventRequestRepository eventRequestRepository){
        this.eventRequestRepository = eventRequestRepository;
    }

    public List<EventRequest> getAllEvents(){
        return this.eventRequestRepository.findAll();
    }

    public EventRequest getEventRequestById(Long id){
        Optional<EventRequest> fetchedRequest = this.eventRequestRepository.findById(id);
        return fetchedRequest.orElse(null);
    }

}
