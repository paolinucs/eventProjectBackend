package it.pssng.eventProject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.pssng.eventProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.fiscalCode = :fiscalCode")
    public Optional<User> findUserByFiscalCode(@Param("fiscalCode") String fiscalCode);

}
