package it.pssng.eventProject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.TicketSupport;
import it.pssng.eventProject.services.mail.TicketSupportMailService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/mail")
@AllArgsConstructor
public class EmailController {

    private final TicketSupportMailService contactUsService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/send_support_ticket")
    public void sendTestEmail(@RequestBody TicketSupport ticket) {
        contactUsService.sendNewTicket(ticket);
        ResponseEntity.ok().build();
    }

}
