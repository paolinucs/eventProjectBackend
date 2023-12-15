package it.pssng.eventProject.repositories;
import it.pssng.eventProject.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

}
