package it.pssng.eventProject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.services.business.PromoterService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/promoters")
@AllArgsConstructor
public class PromoterController {

    private final PromoterService promoterService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/by_id/{id}")
    public ResponseEntity<Promoter> findById(@PathVariable Long id) {
        Promoter fetchedPromoter = promoterService.findPromoterById(id);
        if (fetchedPromoter != null) {
            return ResponseEntity.ok(fetchedPromoter);
        }
        return ResponseEntity.notFound().build();
    }

}
