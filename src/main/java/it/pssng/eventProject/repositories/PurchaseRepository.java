package it.pssng.eventProject.repositories;

import it.pssng.eventProject.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Modifying
    @Query(value = "UPDATE purchase SET ticket = ?2 WHERE purchase-id = ?1", nativeQuery = true)
    public int addTicketDataToPurchase(Long purchaseId, Long ticketId);

}
