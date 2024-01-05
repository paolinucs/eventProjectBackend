package it.pssng.eventProject.services.business;

import it.pssng.eventProject.model.Location;
import it.pssng.eventProject.repos.LocationRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService {

    private LocationRepository locationRepository;

    public Location findLocationById(Long locationId) {
        Optional<Location> foundLocation = locationRepository.findById(locationId);
        return foundLocation.orElse(null);
    }

    public List<Location> findLocationAll() {
        List<Location> foundLocation = locationRepository.findAll();
        return foundLocation;
    }

}
