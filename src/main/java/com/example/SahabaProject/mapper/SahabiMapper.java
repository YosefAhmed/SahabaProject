package com.example.SahabaProject.mapper;

import com.example.SahabaProject.models.Sahabi;
import com.example.SahabaProject.models.dto.SahabiDto;
import com.example.SahabaProject.models.enums.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SahabiMapper {
    SahabiDto toDto(Sahabi sahabi);
    Sahabi toEntity(SahabiDto sahabiDto);

    default int map(Gender gender){
        return gender == Gender.male?0:1;
    }
    default Gender map(int gender){
        return gender == 0? Gender.male:Gender.female;
    }
}
