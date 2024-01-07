package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Promoter;
import it.pssng.eventProject.model.User;
import it.pssng.eventProject.repos.PromoterRepository;
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

    public Promoter findPromoterById(Long id) {
        Optional<Promoter> foundId = promoterRepository.findById(id);
        return foundId.orElse(null);
    }

    public Promoter savePromoter(Promoter data) {
        return promoterRepository.save(data);
    }

    public Optional<Promoter> findPromoterByFiscalCode(User fiscalCode){
        return promoterRepository.findPromoterByFiscalCode(fiscalCode);
    }

    public Optional<Promoter> findPromoterByEmail(String email){
        return promoterRepository.findPromoterByEmail(email);
    }
}
