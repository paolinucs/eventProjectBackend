package it.pssng.eventProject.repositories;

import it.pssng.eventProject.entities.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest,Long> {
}
