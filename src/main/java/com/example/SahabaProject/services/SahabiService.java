package com.example.SahabaProject.services;

import com.example.SahabaProject.models.Sahabi;
import com.example.SahabaProject.repositories.SahabiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SahabiService {
    @Autowired
    SahabiRepo sahabiRepo;
    public Sahabi createSahabi(Sahabi sahabi) {
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
}
