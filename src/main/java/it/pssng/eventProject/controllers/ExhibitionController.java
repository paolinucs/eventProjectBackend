package it.pssng.eventProject.controllers;

import it.pssng.eventProject.entities.Exhibition;
import it.pssng.eventProject.services.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    @Autowired
    public ExhibitionController(ExhibitionService exhibitionService){
        this.exhibitionService = exhibitionService;
    }

    @GetMapping("/all_exh")
    public ResponseEntity<List<Exhibition>> getAllExhibitions(){
        List<Exhibition> returnTuples = exhibitionService.getAll();
        if(!returnTuples.isEmpty()){
            return ResponseEntity.ok(returnTuples);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }
}
