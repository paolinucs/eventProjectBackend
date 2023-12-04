/**
 * File: ExhibitionController.java
 */

package it.pssng.eventProject.controllers;
import it.pssng.eventProject.entities.ArtWork;
import it.pssng.eventProject.services.ArtWorkService;
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

    private final ArtWorkService exhibitionService;

    @Autowired
    public ExhibitionController(ArtWorkService exhibitionService, LocationService locationService){
        this.exhibitionService = exhibitionService;
    }

    /**
     * @GetMapping annotation specify that the method 'getAllExhibitions()' has to be executed when the client requests data through a
     * GET request at the URL, for example, https://pssngexample.xyz/api/entities/all_exh
     */
    @GetMapping("/all_exh")
    public ResponseEntity<List<ArtWork>> getAllArtWorks(){
        List<ArtWork> returnTuples = exhibitionService.getAll();
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
    public ResponseEntity<ArtWork> saveExhibition(@RequestBody ArtWork data){
        ArtWork save = exhibitionService.saveExhibition(data);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/{exhibitionId}")
    public ResponseEntity<ArtWork> getExhibitionById(@PathVariable Long exhibitionId){
        ArtWork foundExhibition = exhibitionService.getExhibitionById(exhibitionId);
        if(foundExhibition == null){
            return ResponseEntity.ok(foundExhibition);
        }
        else{
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/bylocation={exhibitionLocation}")
    public ResponseEntity<List<ArtWork>> getExhibitionByLocation(@PathVariable Long exhibitionLocation){
        List<ArtWork> foundExhibitions = exhibitionService.getExhibitionByLocation(exhibitionLocation);
        if(!foundExhibitions.isEmpty()){
            return ResponseEntity.ok(foundExhibitions);
        }else{
            return ResponseEntity.noContent().build();
        }


    }

}
