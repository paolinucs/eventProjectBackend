package it.pssng.eventProject.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
