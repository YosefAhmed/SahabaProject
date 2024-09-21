package com.example.SahabaProject.controllers;

import com.example.SahabaProject.models.Place;
import com.example.SahabaProject.services.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @PostMapping("/create")
    public Place createPlace(@RequestBody Place place){
        return placeService.createplace(place);
    }

    @GetMapping("/all")
    public List<Place> getAll(){
        return placeService.getAll();
    }

    @GetMapping("/{placeId}")
    public Optional<Place> getPlaceById(@PathVariable String placeName){
        return placeService.getPlaceByName(placeName);
    }

    @GetMapping("/{placeName}")
    public Optional<Place> getPlaceByName(@PathVariable String placeName){
        return placeService.getPlaceByName(placeName);
    }

    @GetMapping("/{currentPlace}")
    public Optional<Place> getPlaceByCurrentPlace(@PathVariable String currentPlace){
        return placeService.getPlaceByCurrentPlace(currentPlace);
    }

    @GetMapping("/{landmark}")
    public Optional<Place> getPlaceByLandmark(@PathVariable String landmark){
        return placeService.getPlaceByLandMark(landmark);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        placeService.deleteAll();
        return "Deleted all Places";
    }

    @DeleteMapping("/remove")
    public String removeById(@RequestParam String name){
        placeService.removeById(name);
        return "Deleted place "+ name;
    }
}
