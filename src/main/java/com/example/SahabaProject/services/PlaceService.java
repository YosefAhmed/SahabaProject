package com.example.SahabaProject.services;

import com.example.SahabaProject.models.Battle;
import com.example.SahabaProject.models.Place;
import com.example.SahabaProject.repositories.PlaceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceService {
    @Autowired
    PlaceRepo placeRepo;

    public Place createplace(Place place) {
        return placeRepo.save(place);
    }

    public List<Place> getAll() {
        return placeRepo.findAll();
    }

    public Map<String, Place> getAllInMap() {
        return placeRepo.findAll().stream().collect(Collectors.toMap(Place::getName, place -> place));
    }

    public Optional<Place> getPlaceByName(String placeName) {
        return placeRepo.findById(placeName);
    }

    public Optional<Place> getPlaceByCurrentPlace(String currentPlace) {
        return placeRepo.findPlaceByCurrentPlace(currentPlace);
    }

    public Optional<Place> getPlaceByLandMark(String landmark) {
        return placeRepo.findPlaceByLandmark(landmark);
    }

    public void deleteAll() {
        placeRepo.deleteAll();
    }

    public void removeById(String name) {
        placeRepo.deleteById(name);
    }
}
