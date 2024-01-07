package it.pssng.eventProject.services.dataTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.FetchEventData;
import it.pssng.eventProject.dto.TicketDTO;
import it.pssng.eventProject.model.Ticket;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.model.Event;
import it.pssng.eventProject.services.business.EventService;
import it.pssng.eventProject.services.business.TicketService;
import it.pssng.eventProject.services.business.UserService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketDtoService {

    private final TicketService ticketService;
    private final EventService eventService;
    private final UserService userService;


    private TicketDTO mapToDataTransfer(Ticket data) {
        TicketDTO mappedData = new TicketDTO();
        mappedData.setEventID(data.getJoinedEvent().getEventId());
        mappedData.setUserID(data.getJoinedUser().getFiscalCode());

        return mappedData;
    }

    public TicketDTO saveNewTicket(FetchEventData eventData, String[] headerData) {
        Ticket newTicket = new Ticket();
        Event fetchedEvent = eventService.getEventById(eventData.getEventId());
        Optional<User> fetchedUser = userService.findUserByFiscalCode(headerData[0]);

        newTicket.setJoinedUser(fetchedUser.get());
        newTicket.setJoinedEvent(fetchedEvent);
        Ticket savedTicket = ticketService.saveTicket(newTicket);

        return this.mapToDataTransfer(savedTicket);

    }

    public List<TicketDTO> getAllTicketsByUser(String[] headerData) {
        Optional<User> fetchedUser = userService.findUserByFiscalCode(headerData[0]);

        List<Ticket> tickets = ticketService.getAllTicketsByUser(fetchedUser.get());
        List<TicketDTO> returnList = new ArrayList<>();
        for (Ticket ticket : tickets)
            returnList.add(this.mapToDataTransfer(ticket));

        return returnList;

    }

}
