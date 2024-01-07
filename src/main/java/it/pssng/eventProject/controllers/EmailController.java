package it.pssng.eventProject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.dto.TicketSupport;
import it.pssng.eventProject.exception.UserNotFoundException;
import it.pssng.eventProject.services.mail.ForgotPasswordMailService;
import it.pssng.eventProject.services.mail.TicketSupportMailService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/mail")
@AllArgsConstructor
public class EmailController {

    private final TicketSupportMailService contactUsService;
    private final ForgotPasswordMailService forgotPasswordMailService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/send_support_ticket")
    public ResponseEntity<Void> sendSupportEmail(@RequestBody TicketSupport ticket) {
        contactUsService.sendNewTicket(ticket);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/retrieve_psw/{userFiscalCode}")
    public ResponseEntity<Void> sendPasswordEmail(@PathVariable String userFiscalCode) throws UserNotFoundException {
        try {
            forgotPasswordMailService.sendNewTicket(userFiscalCode);
            return ResponseEntity.ok().build();
        } catch (UserNotFoundException exc) {
            return ResponseEntity.notFound().build();
        }
    }

}
