package com.example.SahabaProject.models;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "BATTLES")
public class Battle {
        @Id
        private String name;
        @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
        @JoinColumn(name = "battle_location", referencedColumnName = "name")
        private Place location;
        private String yearOfBattle;
        private String enemy;
        private String result;
}
