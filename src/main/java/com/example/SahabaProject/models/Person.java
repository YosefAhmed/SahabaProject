package com.example.SahabaProject.models;
import com.example.SahabaProject.common.Constants;
import com.example.SahabaProject.models.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.Date;
import java.util.Objects;

@Node
@RequiredArgsConstructor
@Setter
public class Person {
    @Id
    private Long id;
    private  String name;
    private String nickname;
    private Gender gender;
////    @Relationship(type = "BELONGS_TO_FAMILY", direction = Relationship.Direction.OUTGOING)
//    private Family family;
////    @Relationship(type = "BELONGS_TO_TRIBE", direction = Relationship.Direction.OUTGOING)
//    private Tribe tribe;
    private String birthDate;
    private  Place placeOfBirth;
    private  String deathDate;
    private  Place placeOfDeath;

    public String getName() {
        return name;
    }

    public String getNickname() {
        return (String) Constants.checkDataStatus(nickname);
    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthDate() {
        return (String) Constants.checkDataStatus(birthDate);
    }

    public Object getPlaceOfBirth() {
        return Constants.checkDataStatus(placeOfBirth);
    }

    public String getDeathDate() {
        return (String) Constants.checkDataStatus(placeOfDeath);
    }

    public Object getPlaceOfDeath() {
        return Constants.checkDataStatus(placeOfDeath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(nickname, person.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname);
    }
}

