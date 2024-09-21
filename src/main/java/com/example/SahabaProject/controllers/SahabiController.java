package com.example.SahabaProject.controllers;

import com.example.SahabaProject.models.Sahabi;
import com.example.SahabaProject.services.SahabiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sahaba")
public class SahabiController {

    @Autowired
    SahabiService sahabiService;
    @PostMapping("/create")
    public Sahabi createSahabi(@RequestBody Sahabi sahabi){
        return sahabiService.createSahabi(sahabi);
    }

    @GetMapping("/all")
    public List<Sahabi> getAll(){
        return sahabiService.getAll();
    }

    @GetMapping("/{sahabiId}")
    public Optional<Sahabi> getSahabiById(@PathVariable long sahabiId){
        return sahabiService.getSahabiById(sahabiId);
    }

    @GetMapping("/{sahabiName}")
    public Optional<Sahabi> getSahabiByName(@PathVariable String sahabiName){
        return sahabiService.getSahabiByName(sahabiName);
    }

    @GetMapping("/{sahabiNickname}")
    public Optional<Sahabi> getSahabiByNickname(@PathVariable String sahabiNickname){
        return sahabiService.getSahabiByNickname(sahabiNickname);
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        sahabiService.deleteAll();
        return "Deleted all Sahaba";
    }

    @DeleteMapping("/remove")
    public String removeById(@RequestParam long id){
        sahabiService.removeById(id);
        return "Deleted sahabi "+id;
    }

}


