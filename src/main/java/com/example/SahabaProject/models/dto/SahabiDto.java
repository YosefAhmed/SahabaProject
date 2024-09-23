package com.example.SahabaProject.models.dto;
import lombok.Data;
import java.util.List;

@Data
public class SahabiDto {

    private String name;
    private String nickname;
    private int gender;
    private String birthYear;
    private String deathYear;
    private String islamYear;
    private String education;
    private String biography;
//    private String roleOrActivity;
    private PlaceDto placeOfBirth;
    private PlaceDto placeOfDeath;
    private List<BattleDto> participatedBattles;

}

