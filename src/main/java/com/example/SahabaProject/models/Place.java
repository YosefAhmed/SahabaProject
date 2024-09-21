package com.example.SahabaProject.models;

import com.example.SahabaProject.models.enums.DirectionFromMecca;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "places")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Place{
    @Id
    private String name;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "currentPlace")
    private String currentPlace;

}
