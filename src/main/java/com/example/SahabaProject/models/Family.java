package com.example.SahabaProject.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
//@Node
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Family{
    private String name;
//    @Relationship(type = "HAS_Father", direction = Relationship.Direction.OUTGOING)
    private  Person father;
//    @Relationship(type = "HAS_Mother", direction = Relationship.Direction.OUTGOING)
    private Person mother;
//    @Relationship(type = "HAS_Brother", direction = Relationship.Direction.OUTGOING)
    private  List<Person> brothers;
//    @Relationship(type = "HAS_Sister", direction = Relationship.Direction.OUTGOING)
    private List<Person> sisters;
}
