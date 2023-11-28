/**
 * File: ExhibitionService.java
 */

package it.pssng.eventProject.services;


import it.pssng.eventProject.entities.Exhibition;
import it.pssng.eventProject.repositories.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Services are the first raw implementation of CRUD operations in your Spring Boot Backend.
 * The annotation @Service has the purpose to reveal this class as a service
 */

@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionService(ExhibitionRepository exhibitionRepository){
        this.exhibitionRepository = exhibitionRepository;
    }

    /**
     * In this section there are implemented all the methods about CRUD operation in the DB.
     * Generally, for data which is obtained in group, you have to return it as a list of that specific entity,
     * otherwise you have to return the single object.
    **/
    public List<Exhibition> getAll(){
        return exhibitionRepository.findAll();
    }

    public Exhibition saveExhibition(Exhibition inputData){
        return exhibitionRepository.save(inputData);
    }

    public Exhibition getExhibitionById(Long inputId){
        Optional<Exhibition> foundExhibition =  exhibitionRepository.findById(inputId);
        if (foundExhibition != null){
            return  foundExhibition.get();
        }else{
            return null;
        }
    }

}
