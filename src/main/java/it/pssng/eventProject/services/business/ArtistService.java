package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Artist;
import it.pssng.eventProject.repos.ArtistRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistService {
    private ArtistRepository artistRepository;

    public Artist findArtistById(Long id) {
        Optional<Artist> foundId = artistRepository.findById(id);
        return foundId.orElse(null);
    }

}
