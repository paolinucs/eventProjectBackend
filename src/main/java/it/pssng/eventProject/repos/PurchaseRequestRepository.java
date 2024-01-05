package it.pssng.eventProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.PurchaseRequest;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest,Long> {
}
