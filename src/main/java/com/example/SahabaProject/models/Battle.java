package com.example.SahabaProject.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "BATTLES")
public class Battle {
        @Id
        private String name;
        @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinColumn(name = "battle_location", referencedColumnName = "name")
        private Place location;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private Date dateOfBattle;
        private String enemy;
        private String result;
}
