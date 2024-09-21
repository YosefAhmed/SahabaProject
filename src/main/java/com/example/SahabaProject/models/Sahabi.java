package com.example.SahabaProject.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Entity
@Data
@Table(name = "SAHABA")
public class Sahabi extends Person {
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "sahabi_battles",
            joinColumns = {@JoinColumn(name = "sahabi_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "battle_name", referencedColumnName = "name")}
    )
    private List<Battle> participatedBattles;
    @Embedded
    private Characteristic characteristics;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date islamDate;
    private String education;
    private List<String> sayingsAndHadiths;
    private String roleOrActivity;
    private String biography;

    /*
     * calculates the age at joining Islam
     * */
    public int getAgeAtIslam() {
        Calendar birthCalender = Calendar.getInstance(), IslamCalender = Calendar.getInstance();
        IslamCalender.setTime(islamDate);
        birthCalender.setTime(getBirthDate());
        return IslamCalender.get(Calendar.YEAR) - birthCalender.get(Calendar.YEAR);
    }
}