package it.pssng.eventProject.services;
import it.pssng.eventProject.entities.Promoter;
import it.pssng.eventProject.repositories.PromoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromoterService {

    private final PromoterRepository promoterRepository;

    @Autowired
    public PromoterService(PromoterRepository promoterRepository){
        this.promoterRepository = promoterRepository;
    }

    public List<Promoter> getAllPromoters(){
        List<Promoter> fetchedPromoters = promoterRepository.findAll();
        return fetchedPromoters;
    }

    public Promoter getPromoterByFiscalCode(String query){
        Optional<Promoter> fetchedPromoter = promoterRepository.findById(query);
        return fetchedPromoter.orElse(null);
    }
}
