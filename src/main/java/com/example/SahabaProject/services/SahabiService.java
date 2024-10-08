package com.example.SahabaProject.services;

import com.example.SahabaProject.mapper.BattleMapper;
import com.example.SahabaProject.mapper.SahabiMapper;
import com.example.SahabaProject.models.Battle;
import com.example.SahabaProject.models.Place;
import com.example.SahabaProject.models.Sahabi;
import com.example.SahabaProject.models.dto.SahabiDto;
import com.example.SahabaProject.repositories.SahabiRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service@AllArgsConstructor
public class SahabiService {
    SahabiRepo sahabiRepo;
    BattleService battleService;
    BattleMapper battleMapper;
    SahabiMapper sahabiMapper;

    @Autowired
    PlaceService placeService;
    public Sahabi createSahabi(SahabiDto sahabiDto) {
        Sahabi sahabi = sahabiMapper.toEntity(sahabiDto);
        List<Battle> selectedBattles = new ArrayList<>();
        // save battles with their locations
        for (Battle battle :
                sahabi.getParticipatedBattles()) {
            Optional<Battle> currentBattle = battleService.getBattleByName(battle.getName());
            if(currentBattle.isPresent()){
                battle = currentBattle.get();
                selectedBattles.add(battle);
            }else {
                Optional<Place> currentPlace = placeService.getPlaceByName(battle.getLocation().getName());
                if(currentPlace.isPresent()){
                    battle.setLocation(currentPlace.get());
                }else{
                    battle.setLocation(placeService.createplace(battle.getLocation()));
                }

                //save the new battles and add it to sahabi
                selectedBattles.add(battleService.createBattle(battle));
            }
        }
        sahabi.setParticipatedBattles(selectedBattles);
        // save place of birth/death
        Optional<Place> currentPlace = placeService.getPlaceByName(sahabi.getPlaceOfBirth().getName());
        if(currentPlace.isPresent()){
            sahabi.setPlaceOfBirth(currentPlace.get());
        }else{
            sahabi.setPlaceOfBirth(placeService.createplace(sahabi.getPlaceOfBirth()));
        }

        currentPlace = placeService.getPlaceByName(sahabi.getPlaceOfDeath().getName());
        if(currentPlace.isPresent()){
            sahabi.setPlaceOfDeath(currentPlace.get());
        }else{
            sahabi.setPlaceOfDeath(placeService.createplace(sahabi.getPlaceOfDeath()));
        }
        return sahabiRepo.save(sahabi);
    }

    public List<Sahabi> getAll() {
        return sahabiRepo.findAll();
    }

    public Optional<Sahabi> getSahabiById(long sahabiId) {
        return sahabiRepo.findById(sahabiId);
    }

    public void deleteAll() {
        sahabiRepo.deleteAll();
    }

    public Optional<Sahabi> getSahabiByName(String sahabiName) {
        return sahabiRepo.findByName(sahabiName);
    }

    public Optional<Sahabi> getSahabiByNickname(String sahabiNickname) {
        return sahabiRepo.findByNickname(sahabiNickname);
    }

    public void removeById(long id) {
        sahabiRepo.deleteById(id);
    }
}
