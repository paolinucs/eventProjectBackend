package it.pssng.eventProject.services;

import it.pssng.eventProject.entities.Artist_Request;
import it.pssng.eventProject.repositories.ArtistRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ArtistRequestService {

    private ArtistRequestRepository artistRequestRepository;

    @Autowired
    public ArtistRequestService(ArtistRequestRepository artistRequestRepository) {this.artistRequestRepository = artistRequestRepository;}

    public Artist_Request findArtistRequestByRequestId(Long requestId){
        Optional<Artist_Request> foundArtistRequest = artistRequestRepository.findById(requestId);
        return foundArtistRequest.orElse(null);
    }

}
