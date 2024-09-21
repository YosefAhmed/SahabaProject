package com.example.SahabaProject.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;

import java.util.List;

@Embeddable
public class Characteristic{
    @ElementCollection
    List<String> appearance;
    @ElementCollection
    List<String> personality;
}