package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.PurchaseRequest;
import it.pssng.eventProject.repositories.PurchaseRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseRequestService {
    private PurchaseRequestRepository purchaseRequestRepository;

    @Autowired
    public PurchaseRequestService(PurchaseRequestRepository purchaseRequestRepository){this.purchaseRequestRepository = purchaseRequestRepository; }

    public PurchaseRequest findPurchaseRequestById(Long purchaseRequestId){
        Optional<PurchaseRequest> foundPurchaseRequest = purchaseRequestRepository.findById(purchaseRequestId);
        return foundPurchaseRequest.orElse(null);
    }

    public List<PurchaseRequest> findPurchaseRequestAll(){
        List<PurchaseRequest> foundPurchaseRequest = purchaseRequestRepository.findAll();
        return foundPurchaseRequest;
    }
}
