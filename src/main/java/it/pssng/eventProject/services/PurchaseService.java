package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Customer;
import it.pssng.eventProject.entities.Purchase;
import it.pssng.eventProject.entities.Ticket;
import it.pssng.eventProject.repositories.PurchaseRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public Purchase findPurchaseById(Long purchaseId) {
        Optional<Purchase> foundPurchase = purchaseRepository.findById(purchaseId);
        return foundPurchase.orElse(null);
    }

    public List<Purchase> findPurchaseAll() {
        List<Purchase> foundPurchase = purchaseRepository.findAll();
        return foundPurchase;
    }

    public Purchase savePurchase(Purchase data) {
        return purchaseRepository.save(data);
    }

    public boolean setTicketData(Purchase purchaseData, Ticket ticketData) {
        int isUpdated = purchaseRepository.addTicketDataToPurchase(purchaseData.getPurchaseId(),
                ticketData.getTicketId());
        return isUpdated == 1;
    }

    public boolean deletePurchase(Purchase data) {
        try {
            purchaseRepository.delete(data);
        } catch (Exception exc) {
            throw new RuntimeException();
        }

        return true;
    }

}
