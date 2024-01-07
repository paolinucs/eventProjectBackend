package it.pssng.eventProject.services.mail;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.EventRequestDTO;
import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.services.business.PromoterService;
import it.pssng.eventProject.services.business.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RequestMailService {

        @Value("${eventProject.email.ticket}")
        private String mailSupport;

        @Value("${eventProject.disclaimer}")
        private String disclaimer;

        private final GenericMailClass genericMailClass;
        private final PromoterService promoterService;
        private final UserService userService;

        public void sendEventRequestMail(EventRequestDTO eventRequestData) {

                Optional<User> user = userService.findUserByFiscalCode(eventRequestData.getPromoterFiscalCode());

                Optional<Promoter> askingPromoter = promoterService.findPromoterByFiscalCode(user.get());

                String mailSubject = "New Event Request from " + askingPromoter.get().getPromoterName() + " "
                                + askingPromoter.get().getPromoterSurname() + "[request id."
                                + eventRequestData.getEventRequestId() + "]";

                String mailText = askingPromoter.get().getPromoterName() + " " + askingPromoter.get().getPromoterSurname()
                                + " is requesting to host a new event.\n\n Request data:\n"
                                + "Event name: "
                                + eventRequestData.getEventName()
                                + "\n\n" + "Event start date: "
                                + eventRequestData.getExpectedEventStart()
                                + "\nEvent end date: "
                                + eventRequestData.getExpectedEventEnd()
                                + "\n\nLocation name: "
                                + eventRequestData.getLocationName()
                                + "\nLocation description: "
                                + eventRequestData.getLocationDescription()
                                + "\n\n\n You can review the request into the admin requests page.\n\n\n\nn\\"
                                + this.disclaimer;

                String devArea = "\n\n\n\n\n\n----------------------DEV AREA-------------------------\nDue to this app is still in develop stage you can:\n\nACCEPT REQUEST: http://localhost:3000/api/mail/accept_event_request/"
                                + eventRequestData.getEventRequestId()
                                + "\nDECLINE REQUEST: http://localhost:3000/api/mail/decline_event-request/"
                                + eventRequestData.getEventRequestId();

                genericMailClass.sendSimpleMessage("noreply@eventProject", "eventrequest@eventProject", mailSubject,
                                mailText + devArea);

        }

}
