package it.pssng.eventProject.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import it.pssng.eventProject.model.User;
public interface UserRepository extends JpaRepository<User, String> {
}
