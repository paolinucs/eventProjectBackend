package it.pssng.eventProject.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.pssng.eventProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM `user-data` WHERE `fiscal-code` = ?1", nativeQuery = true)
    public Optional<User> findUserByFiscalCode(String fiscalCode);

}
