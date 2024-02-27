package com.example.SahabaProject.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class Battle {
        private String name;
        private Date date;
        private Place location;
        private String enemy;
        private String result;
}