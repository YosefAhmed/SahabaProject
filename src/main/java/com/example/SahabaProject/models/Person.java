package com.example.SahabaProject.models;
import com.example.SahabaProject.models.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Objects;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONS")
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeOfBirth_id")
    private  Place placeOfBirth;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placeOfDeath_id")
    private  Place placeOfDeath;
    private  String name;
    private String nickname;
    private Gender gender;
    private String birthYear;
    private  String deathYear;
    @Override
    public boolean equals(Object o) {
        if(o instanceof Person) {
            return Objects.equals(name, ((Person) o).name) &&
                    Objects.equals(nickname, ((Person) o).nickname);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nickname);
    }
}

