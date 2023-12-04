package it.pssng.eventProject.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import it.pssng.eventProject.entities.User;
public interface UserRepository extends JpaRepository<User, String> {
}
