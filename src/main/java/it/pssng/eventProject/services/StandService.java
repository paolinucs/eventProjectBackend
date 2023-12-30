package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Stand;
import it.pssng.eventProject.repositories.StandRepository;
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
