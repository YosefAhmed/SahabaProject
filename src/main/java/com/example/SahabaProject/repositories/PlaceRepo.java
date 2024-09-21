package com.example.SahabaProject.repositories;

import com.example.SahabaProject.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepo extends JpaRepository<Place, String> {
//    @Query("SELECT p FROM Place p WHERE p.name = :name")
//
//    Optional<Place> findPlaceByName(@Param("name") String placeName);
    @Query("SELECT p FROM Place p WHERE p.currentPlace = :currentPlace")
    Optional<Place> findPlaceByCurrentPlace(@Param("currentPlace") String currentPlace);
    @Query("SELECT p FROM Place p WHERE p.landmark = :landmark")
    Optional<Place> findPlaceByLandmark(@Param("landmark") String landmark);
}
