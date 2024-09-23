package com.example.SahabaProject.models.dto;
import lombok.Data;

@Data
public class BattleDto {
    private String name;
    private String yearOfBattle;
    private String enemy;
    private String result;
    private PlaceDto location;
}
