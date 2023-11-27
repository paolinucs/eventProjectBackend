/**
 * File: ExhibitionService.java
 * Author: Paolo Coletta
 */

package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Exhibition;
import it.pssng.eventProject.repositories.ExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExhibitionService {

    private final ExhibitionRepository exhibitionRepository;

    @Autowired
    public ExhibitionService(ExhibitionRepository exhibitionRepository){
        this.exhibitionRepository = exhibitionRepository;
    }

    public List<Exhibition> getAll(){
        return exhibitionRepository.findAll();
    }

}
