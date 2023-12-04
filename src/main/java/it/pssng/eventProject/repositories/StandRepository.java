package it.pssng.eventProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import it.pssng.eventProject.entities.Stand;

public interface StandRepository extends JpaRepository<Stand, Long> {
}
