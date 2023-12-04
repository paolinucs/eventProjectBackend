package it.pssng.eventProject.repositories;

import it.pssng.eventProject.entities.Promoter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoterRepository extends JpaRepository<Promoter,String> {
}
