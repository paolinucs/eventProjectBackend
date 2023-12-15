package it.pssng.eventProject.repositories;

import it.pssng.eventProject.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
