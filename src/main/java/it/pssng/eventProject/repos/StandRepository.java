package it.pssng.eventProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.Stand;

public interface StandRepository extends JpaRepository<Stand, Long> {
}
