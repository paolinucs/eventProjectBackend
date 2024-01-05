package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Stand;
import it.pssng.eventProject.repos.StandRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StandService {
    private final StandRepository standRepository;

    public Stand findStandByStandId(Long StandId) {
        Optional<Stand> foundStand = standRepository.findById(StandId);
        return foundStand.orElse(null);
    }
}
