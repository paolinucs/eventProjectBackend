package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Purchase;
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

}
