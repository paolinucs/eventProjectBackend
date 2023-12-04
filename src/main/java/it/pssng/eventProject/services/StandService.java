package it.pssng.eventProject.services;
import it.pssng.eventProject.entities.Stand;
import it.pssng.eventProject.repositories.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StandService {
    private StandRepository standRepository;

    @Autowired
    public StandService(StandRepository standRepository){ this.standRepository = standRepository; }

    public Stand findStandByStandId(Long StandId){
        Optional<Stand> foundStand = standRepository.findById(StandId);
        return foundStand.orElse(null);
    }
}
