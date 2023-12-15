package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Ticket;
import it.pssng.eventProject.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private TicketRepository ticketRepository;

    @Autowired //costruttore si riempie da solo
    public TicketService(TicketRepository ticketRepository) { this.ticketRepository = ticketRepository; }

    //RICERCA TRAMITE ID
    public Ticket findTicketById(Long ticketCode){
        //OPTIONAL PERCHÉ POTREBBE NON ESSERCI- FINDBYID FUNZIONE PRESENTE IN JDAREPOSITORY
        Optional<Ticket> foundTicket = ticketRepository.findById(ticketCode);
        //RESTITUISCE L'ELEMENTO TROVATO ALTRIMENTI NULL
        return foundTicket.orElse(null);
    }

    public List<Ticket> findTicketAll(){
        //FIND ALL FUNZIONE PRESENTE IN JDAREPOSITORY
        List<Ticket> foundTicket = ticketRepository.findAll();
        return foundTicket;
    }

}
