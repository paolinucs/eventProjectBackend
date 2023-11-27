/**
 * File: ExhibitionRepository.java
 * Author: Paolo Coletta
 */

package it.pssng.eventProject.repositories;
import it.pssng.eventProject.entities.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExhibitionRepository extends JpaRepository<Exhibition,Long> {
    //override or overload if necessary
}
