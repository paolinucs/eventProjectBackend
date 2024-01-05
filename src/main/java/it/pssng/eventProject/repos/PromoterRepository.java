package it.pssng.eventProject.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.Promoter;

public interface PromoterRepository extends JpaRepository<Promoter,String> {
}
