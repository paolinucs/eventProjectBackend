package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Promoter;
import it.pssng.eventProject.repositories.PromoterRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PromoterService {

    private final PromoterRepository promoterRepository;

    public List<Promoter> getAllPromoters() {
        List<Promoter> fetchedPromoters = promoterRepository.findAll();
        return fetchedPromoters;
    }

    public Promoter getPromoterByFiscalCode(String query) {
        Optional<Promoter> fetchedPromoter = promoterRepository.findById(query);
        return fetchedPromoter.orElse(null);
    }
}
