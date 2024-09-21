package com.example.SahabaProject.models;
import com.example.SahabaProject.models.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.Objects;


@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONS")
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "placeOfBirth_id")
    private  Place placeOfBirth;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "placeOfDeath_id")
    private  Place placeOfDeath;
    private  String name;
    private String nickname;
    private Gender gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private  Date deathDate;
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

