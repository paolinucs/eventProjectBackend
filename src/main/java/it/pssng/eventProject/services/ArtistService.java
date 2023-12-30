package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Artist;
import it.pssng.eventProject.repositories.ArtistRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistService {
    private ArtistRepository artistRepository;

    public Artist findArtistByFiscalCode(String fiscalCode) {
        Optional<Artist> foundFiscalCode = artistRepository.findById(fiscalCode);
        return foundFiscalCode.orElse(null);
    }

}
