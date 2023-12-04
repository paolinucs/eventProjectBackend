/**
 * File: ExhibitionRepository.java
 */

package it.pssng.eventProject.repositories;
import it.pssng.eventProject.entities.ArtWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


/**
 * In Spring Boot framework, repositories are interfaces that extends the already existing JpaRepository.
 * In this source code you are free to override or overload already existing methods in order to fit them to your needs.
 */

 // You must specify the Entity which this repository references to and the type of entity's primary key
public interface ArtWorkRepository extends JpaRepository<ArtWork,Long> {
    @Query(value = "SELECT * FROM exhibitions WHERE location = ?1", nativeQuery = true)
    List<ArtWork> findByLocation(Long locationToSearch);
}


