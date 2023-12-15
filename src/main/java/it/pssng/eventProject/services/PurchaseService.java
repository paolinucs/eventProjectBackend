package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Purchase;
import it.pssng.eventProject.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    private PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {this.purchaseRepository = purchaseRepository; }

    public Purchase findPurchaseById(Long purchaseId){
        Optional<Purchase> foundPurchase = purchaseRepository.findById(purchaseId);
        return foundPurchase.orElse(null);
    }
    public List<Purchase> findPurchaseAll(){
        List<Purchase> foundPurchase = purchaseRepository.findAll();
        return foundPurchase;
    }

}
