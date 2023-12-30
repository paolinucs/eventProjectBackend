package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.PurchaseRequest;
import it.pssng.eventProject.repositories.PurchaseRequestRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PurchaseRequestService {
    private final PurchaseRequestRepository purchaseRequestRepository;

    public PurchaseRequest findPurchaseRequestById(Long purchaseRequestId) {
        Optional<PurchaseRequest> foundPurchaseRequest = purchaseRequestRepository.findById(purchaseRequestId);
        return foundPurchaseRequest.orElse(null);
    }

    public List<PurchaseRequest> findPurchaseRequestAll() {
        List<PurchaseRequest> foundPurchaseRequest = purchaseRequestRepository.findAll();
        return foundPurchaseRequest;
    }
}
