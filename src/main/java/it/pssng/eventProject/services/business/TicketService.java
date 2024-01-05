package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Ticket;
import it.pssng.eventProject.repos.TicketRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    // RICERCA TRAMITE ID
    public Ticket findTicketById(Long ticketCode) {
        // OPTIONAL PERCHÉ POTREBBE NON ESSERCI- FINDBYID FUNZIONE PRESENTE IN
        // JPAREPOSITORY
        Optional<Ticket> foundTicket = ticketRepository.findById(ticketCode);
        // RESTITUISCE L'ELEMENTO TROVATO ALTRIMENTI NULL
        return foundTicket.orElse(null);
    }

    public List<Ticket> findTicketAll() {
        // FIND ALL FUNZIONE PRESENTE IN JPAREPOSITORY
        List<Ticket> foundTicket = ticketRepository.findAll();
        return foundTicket;
    }

    public Ticket saveTicket(Ticket data) {
        return ticketRepository.save(data);
    }

    public boolean deleteTicket(Ticket data) {
        try {
            ticketRepository.delete(data);
        } catch (Exception exc) {
            throw new RuntimeException();
        }

        return true;
    }

}
