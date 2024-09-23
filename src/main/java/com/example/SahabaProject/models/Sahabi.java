package com.example.SahabaProject.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@Table(name = "SAHABA")
public class Sahabi extends Person {
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "sahabi_battles",
            joinColumns = {@JoinColumn(name = "sahabi_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "battle_name", referencedColumnName = "name")}
    )
    private List<Battle> participatedBattles;
//    @Embedded
//    private Characteristic characteristics;
    private String islamYear;
    private String education;
//    private List<String> sayingsAndHadiths;
//    private String roleOrActivity;
    private String biography;

    /*
     * calculates the age at joining Islam
     * */
    public int getAgeAtIslam() {
        return Integer.parseInt(islamYear)-Integer.parseInt(getBirthYear());
    }
}