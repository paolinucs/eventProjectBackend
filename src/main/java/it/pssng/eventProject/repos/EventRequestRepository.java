package it.pssng.eventProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.pssng.eventProject.model.EventRequest;
import jakarta.transaction.Transactional;

public interface EventRequestRepository extends JpaRepository<EventRequest, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE EventRequest e SET e.isAccepted = true WHERE e.eventRequestId = :id")
    public void acceptRequestById(@Param("id") Long requestId);

    @Transactional
    @Modifying
    @Query("UPDATE EventRequest e SET e.isAccepted = false WHERE e.eventRequestId = :id")
    public void declineRequestById(@Param("id") Long requestId);


}
