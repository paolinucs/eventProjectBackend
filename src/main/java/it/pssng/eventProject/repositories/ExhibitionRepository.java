/**
 * File: ExhibitionRepository.java
 */

package it.pssng.eventProject.repositories;
import it.pssng.eventProject.entities.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * In Spring Boot framework, repositories are interfaces that extends the already existing JpaRepository.
 * In this source code you are free to override or overload already existing methods in order to fit them to your needs.
 */

 // You must specify the Entity which this repository references to and the type of entity's primary key
public interface ExhibitionRepository extends JpaRepository<Exhibition,Long> {
    //override or overload if necessary
}
