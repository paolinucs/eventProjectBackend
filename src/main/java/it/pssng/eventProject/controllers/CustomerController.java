package it.pssng.eventProject.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import it.pssng.eventProject.dto.UnregisteredTicketPurchaseDto;
import it.pssng.eventProject.exception.DataNotCorrectlySavedException;
import it.pssng.eventProject.exception.EventNotFoundException;
import it.pssng.eventProject.services.business.UnregisteredTicketPurchaseService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customer/")
public class CustomerController {

    private final UnregisteredTicketPurchaseService unregisteredTicketPurchaseService;
    @PostMapping("/buy_as_unregistered")
    public ResponseEntity<Boolean> buyAsUnregistered(@RequestBody UnregisteredTicketPurchaseDto data)
            throws DataNotCorrectlySavedException, EventNotFoundException {
        try {
            unregisteredTicketPurchaseService.purchaseTicket(data);
        } catch (DataNotCorrectlySavedException exc) {
            return ResponseEntity.badRequest().build();
        } catch (EventNotFoundException exc) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(true);

    }

}
