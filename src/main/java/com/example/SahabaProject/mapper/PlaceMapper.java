package com.example.SahabaProject.mapper;

import com.example.SahabaProject.models.Place;
import com.example.SahabaProject.models.dto.PlaceDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlaceMapper {
    PlaceDto toDto(Place place);
    Place toEntity(PlaceDto placeDto);
}
