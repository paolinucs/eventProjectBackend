package it.pssng.eventProject.services;
import it.pssng.eventProject.entities.Artist;
import it.pssng.eventProject.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ArtistService {
    private ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository){this.artistRepository = artistRepository;}

    public Artist findArtistByFiscalCode(String fiscalCode){
        Optional<Artist> foundFiscalCode = artistRepository.findById(fiscalCode);
                return foundFiscalCode.orElse(null);
    }

}
