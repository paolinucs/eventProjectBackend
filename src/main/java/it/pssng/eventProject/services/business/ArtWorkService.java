/**
 * File: ExhibitionService.java
 */

package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.ArtWork;
import it.pssng.eventProject.repos.ArtWorkRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Services are the first raw implementation of CRUD operations in your Spring
 * Boot Backend.
 * The annotation @Service has the purpose to reveal this class as a service
 */

@Service
@AllArgsConstructor
public class ArtWorkService {

    private final ArtWorkRepository exhibitionRepository;

    /**
     * In this section there are implemented all the methods about CRUD operation in
     * the DB.
     * Generally, for data which is obtained in group, you have to return it as a
     * list of that specific entity,
     * otherwise you have to return the single object.
     **/
    public List<ArtWork> getAll() {
        return exhibitionRepository.findAll();
    }

    public ArtWork saveExhibition(ArtWork inputData) {
        return exhibitionRepository.save(inputData);
    }

    public ArtWork getExhibitionById(Long inputId) {
        Optional<ArtWork> foundExhibition = exhibitionRepository.findById(inputId);
        return foundExhibition.orElse(null);
    }

    public List<ArtWork> getExhibitionByLocation(Long inputLocation) {
        List<ArtWork> foundExhibition = exhibitionRepository.findByLocation(inputLocation);
        if (foundExhibition.isEmpty()) {
            return null;
        } else {
            return foundExhibition;
        }
    }

}
