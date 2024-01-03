package it.pssng.eventProject.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import it.pssng.eventProject.dto.UnregisteredTicketPurchaseDto;
import it.pssng.eventProject.entities.Customer;
import it.pssng.eventProject.entities.Event;
import it.pssng.eventProject.entities.Purchase;
import it.pssng.eventProject.entities.Ticket;
import it.pssng.eventProject.exception.DataNotCorrectlySavedException;
import it.pssng.eventProject.exception.EventNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UnregisteredTicketPurchaseService {

    private final CustomerService customerService;
    private final PurchaseService purchaseService;
    private final EventService eventService;
    private final TicketService ticketService;

    public void purchaseTicket(UnregisteredTicketPurchaseDto data)
            throws DataNotCorrectlySavedException, EventNotFoundException {

        Event requestEvent = eventService.getEventById(data.getEventId());

        if (requestEvent == null)
            throw new EventNotFoundException();

        // salvataggio di customer
        Customer newCustomer = new Customer();
        if (customerService.findCustomerByFiscalCode(data.getFiscalCode()) == null) {
            newCustomer.setCustomerFiscalCode(data.getFiscalCode());
            newCustomer.setCustomerName(data.getCustomerName());
            newCustomer.setCustomerSurname(data.getCustomerSurname());
            newCustomer.setCustomerEmail(data.getCustomerEmail());
            newCustomer.setPhoneNumber(data.getPhoneNumber());
            Customer savedCustomer = customerService.saveCustomer(newCustomer);
            if (!savedCustomer.equals(newCustomer)) {
                customerService.deleteCustomer(savedCustomer);
                throw new DataNotCorrectlySavedException();
            }

        }

        Purchase newPurchase = new Purchase();
        newPurchase.setPurchaseAmount(data.getPurchaseAmount());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        newPurchase.setPurchaseDate(LocalDateTime.now().format(formatter));

        newPurchase.setJoinedCustomer(newCustomer);
        Purchase savedPurchase = purchaseService.savePurchase(newPurchase);
        Long savedPurchaseId = savedPurchase.getPurchaseId();
        savedPurchase.setPurchaseId(null);

        if (!savedPurchase.equals(newPurchase)) {
            savedPurchase.setPurchaseId(savedPurchaseId);
            purchaseService.deletePurchase(savedPurchase);
            throw new DataNotCorrectlySavedException();
        }
        // a questo punto diamo per assunto che il pagamento sia andato a buon fine...

        Ticket newTicket = new Ticket();
        newTicket.setJoinedEvent(requestEvent);
        newTicket.setJoinedCustomer(newCustomer);
        Ticket savedTicket = ticketService.saveTicket(newTicket);
        Long savedTicketId = savedTicket.getTicketId();
        savedTicket.setTicketId(null);

        if (!savedTicket.equals(newTicket)) {
            savedTicket.setTicketId(savedTicketId);
            ticketService.deleteTicket(savedTicket);
            throw new DataNotCorrectlySavedException();
        }

        boolean isPurchaseUpdated = purchaseService.setTicketData(savedPurchase, savedTicket);

        if (!isPurchaseUpdated) {
            savedPurchase.setPurchaseId(savedPurchaseId);
            purchaseService.deletePurchase(savedPurchase);
            throw new DataNotCorrectlySavedException();
        }
    }

}
