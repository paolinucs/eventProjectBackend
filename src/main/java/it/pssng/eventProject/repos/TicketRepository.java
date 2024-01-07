package it.pssng.eventProject.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.pssng.eventProject.model.Ticket;
import it.pssng.eventProject.model.User;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.joinedUser = :user")
    public List<Ticket> findTicketByUser(@Param("user") User data);

}
