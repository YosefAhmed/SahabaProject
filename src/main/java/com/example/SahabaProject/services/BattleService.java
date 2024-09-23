package com.example.SahabaProject.services;

import com.example.SahabaProject.models.Battle;
import com.example.SahabaProject.models.Place;
import com.example.SahabaProject.repositories.BattleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BattleService {
    @Autowired
    BattleRepo battleRepo;

    public Battle createBattle(Battle battle) {
        return battleRepo.save(battle);
    }

    public List<Battle> getAll() {
        return battleRepo.findAll();
    }

    public Map<String,Battle> getAllInMap() {
        return battleRepo.findAll().stream().collect(Collectors.toMap(Battle::getName, battle -> battle));
    }

    public Optional<Battle> getBattleByName(String battleName) {
        return battleRepo.findById(battleName);
    }

    public Optional<Battle> getBattleByEnemy(String enemy) {
        return battleRepo.findBattleByEnemy(enemy);
    }

    public Optional<Battle> getBattleByYearOfBattle(String yearOfBattle) {
        return battleRepo.findBattleByYearOfBattle(yearOfBattle);
    }

    public List<Battle> getBattlesByLocation(Place location) {
        return battleRepo.findByLocation(location);
    }

    public List<Battle> getBattlesByResult(String result) {
        return battleRepo.findByResult(result);
    }

    public void deleteAll() {
        battleRepo.deleteAll();
    }

    public void removeById(String name) {
        battleRepo.deleteById(name);
    }
}
