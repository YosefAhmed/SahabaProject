package com.example.SahabaProject.mapper;

import com.example.SahabaProject.models.Battle;
import com.example.SahabaProject.models.dto.BattleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BattleMapper {
    BattleDto toDto(Battle battle);
    Battle toEntity(BattleDto battleDto);
}
