package com.example.SahabaProject.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
//@Node
@NoArgsConstructor
@AllArgsConstructor
public class Tribe{
    private  String name;
//    @Relationship(type = "HAS_Sister_Family", direction = Relationship.Direction.OUTGOING)
    private  List<Family> families;
}