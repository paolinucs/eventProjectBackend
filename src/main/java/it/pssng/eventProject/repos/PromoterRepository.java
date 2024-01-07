package it.pssng.eventProject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.model.User;

public interface PromoterRepository extends JpaRepository<Promoter, Long> {

    @Query("SELECT p FROM Promoter p WHERE p.promoterFiscalCode = :fiscalCode")
    public Optional<Promoter> findPromoterByFiscalCode(@Param("fiscalCode") User fiscalCode);

}
