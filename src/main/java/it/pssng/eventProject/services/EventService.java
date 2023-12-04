package it.pssng.eventProject.services;
import it.pssng.eventProject.entities.Event;
import it.pssng.eventProject.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

        private final EventRepository eventRepository;

        @Autowired
        public EventService(EventRepository eventRepository){
            this.eventRepository = eventRepository;
        }

        public List<Event> getAllEvents(){
            List<Event> fetchedEvents = eventRepository.findAll();
            return fetchedEvents;
        }

        public Event getEventById(Long id){
            Optional<Event> fetchedEvent = eventRepository.findById(id);
            return fetchedEvent.orElse(null);
        }

}
