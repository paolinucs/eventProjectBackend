package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.ArtistRequest;
import it.pssng.eventProject.repositories.ArtistRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArtistRequestService {

    private ArtistRequestRepository artistRequestRepository;

    @Autowired
    public ArtistRequestService(ArtistRequestRepository artistRequestRepository) {
        this.artistRequestRepository = artistRequestRepository;
    }

    public ArtistRequest findArtistRequestByRequestId(Long requestId) {
        Optional<ArtistRequest> foundArtistRequest = artistRequestRepository.findById(requestId);
        return foundArtistRequest.orElse(null);
    }

}
