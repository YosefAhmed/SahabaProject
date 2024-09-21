package com.example.SahabaProject.controllers;

import com.example.SahabaProject.models.Battle;
import com.example.SahabaProject.services.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/battles")
public class BattleController {

    @Autowired
    BattleService battleService;

    @PostMapping("/create")
    public Battle createBattle(@RequestBody Battle battle){
        return battleService.createBattle(battle);
    }

    @GetMapping("/all")
    public List<Battle> getAllBattles(){
        return battleService.getAll();
    }

    @GetMapping("/{battleId}")
    public Optional<Battle> getBattleById(@PathVariable String battleName){
        return battleService.getBattleByName(battleName);
    }

    @GetMapping("/name/{battleName}")
    public Optional<Battle> getBattleByName(@PathVariable String battleName){
        return battleService.getBattleByName(battleName);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllBattles(){
        battleService.deleteAll();
        return "Deleted all battles";
    }

    @DeleteMapping("/remove")
    public String removeById(@RequestParam String name){
        battleService.removeById(name);
        return "Deleted battle "+name;
    }
}
