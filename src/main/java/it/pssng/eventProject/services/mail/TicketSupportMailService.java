package it.pssng.eventProject.services.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.TicketSupport;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketSupportMailService {

    private final GenericMailClass genericMailClass;

    @Value("${eventProject.email.ticket}")
    private String mailSupport;

    @Value("${eventProject.disclaimer}")
    private String disclaimer;

    public void sendNewTicket(TicketSupport ticket) {

        String emailSubject = ticket.getUserRealName() + " " + ticket.getUserRealSurname() + " requires support.";
        String emailText = ticket.getUserRealName() + " " + ticket.getUserRealSurname() + " at <inserire orario>:\n\n"
                + ticket.getTicketDescription()
                + "\n\n\n\n\n-----------------------------------------O-----------------------------------------\n"
                + this.disclaimer;


        genericMailClass.sendSimpleMessage(ticket.getUserEmail(), mailSupport, emailSubject, emailText);
    }

}
