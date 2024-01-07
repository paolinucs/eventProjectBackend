package it.pssng.eventProject.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.FetchEventData;
import it.pssng.eventProject.dto.TicketDTO;
import it.pssng.eventProject.services.dataTransfer.TicketDtoService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tickets/")
public class TicketController {

    private final TicketDtoService ticketDtoService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/buy_ticket")
    public ResponseEntity<TicketDTO> saveNewTicket(@RequestBody FetchEventData eventData,
            @RequestHeader("user_metadata") String[] usrMtd) {
        TicketDTO savedTicket = ticketDtoService.saveNewTicket(eventData, usrMtd);
        return ResponseEntity.ok(savedTicket);
    }

    @CrossOrigin(origins="http://localhost:3000/")
    @GetMapping("/get_by_user")
    public ResponseEntity<List<TicketDTO>> getTicketByFiscalCode(@RequestHeader("user_metadata") String[] usrMtd) {
        List<TicketDTO> fetchedTickets = ticketDtoService.getAllTicketsByUser(usrMtd);
        return ResponseEntity.ok(fetchedTickets);
    }
}
