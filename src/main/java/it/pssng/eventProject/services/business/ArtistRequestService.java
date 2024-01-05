package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.ArtistRequest;
import it.pssng.eventProject.repos.ArtistRequestRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistRequestService {

    private final ArtistRequestRepository artistRequestRepository;

    public ArtistRequest findArtistRequestByRequestId(Long requestId) {
        Optional<ArtistRequest> foundArtistRequest = artistRequestRepository.findById(requestId);
        return foundArtistRequest.orElse(null);
    }

}
