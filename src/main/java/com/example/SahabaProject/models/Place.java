package com.example.SahabaProject.models;

import com.example.SahabaProject.models.enums.DirectionFromMecca;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
@Getter
public class Place{
    private String name;
    private String landMark;
    private DirectionFromMecca directionFromMecca;
    private String currentPlace;

}
