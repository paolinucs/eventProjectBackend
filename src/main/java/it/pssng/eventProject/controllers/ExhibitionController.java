/**
 * File: ExhibitionController.java
 */

package it.pssng.eventProject.controllers;
import it.pssng.eventProject.entities.Exhibition;
import it.pssng.eventProject.entities.Location;
import it.pssng.eventProject.services.ExhibitionService;
import it.pssng.eventProject.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The Rest Controller is the last piece of this simple implementation.
 * @RequestMapping annotation specify where all these operations can be executed (example: https://pssngexample.xyz/api/entities)
 */

@RestController
@RequestMapping("/api/exhibitions")
public class ExhibitionController {

    private final ExhibitionService exhibitionService;

    @Autowired
    public ExhibitionController(ExhibitionService exhibitionService, LocationService locationService){
        this.exhibitionService = exhibitionService;
    }

    /**
     * @GetMapping annotation specify that the method 'getAllExhibitions()' has to be executed when the client requests data through a
     * GET request at the URL, for example, https://pssngexample.xyz/api/entities/all_exh
     */
    @GetMapping("/all_exh")
    public ResponseEntity<List<Exhibition>> getAllExhibitions(){
        List<Exhibition> returnTuples = exhibitionService.getAll();
        /**
         * In this method there are also handled errors in the request:
         * If the getAll function of exhibitionService does not return empty data, you can return a response (with your data obv)
         * Otherwise, will be sent the no content response to the client
         */
        if(!returnTuples.isEmpty()){
            return ResponseEntity.ok(returnTuples);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping("/save_exh")
    public ResponseEntity<Exhibition> saveExhibition(@RequestBody Exhibition data){
        Exhibition save = exhibitionService.saveExhibition(data);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{exhibitionId}")
    public ResponseEntity<Exhibition> getExhibitionById(@PathVariable Long exhibitionId){
        Exhibition foundExhibition = exhibitionService.getExhibitionById(exhibitionId);
        if(foundExhibition == null){
            return ResponseEntity.ok(foundExhibition);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/bylocation={exhibitionLocation}")
    public ResponseEntity<List<Exhibition>> getExhibitionByLocation(@PathVariable Long exhibitionLocation){
        List<Exhibition> foundExhibitions = exhibitionService.getExhibitionByLocation(exhibitionLocation);
        if(!foundExhibitions.isEmpty()){
            return ResponseEntity.ok(foundExhibitions);
        }else{
            return ResponseEntity.noContent().build();
        }


    }

}
