package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.CompetitionDTO;
import com.daniel.competitions.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper (componentModel = "spring", uses = {CompetitionTeamsMapper.class}, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CompetitionMapper {

    @Mappings({
            @Mapping(target = "categoryId", source = "category.id"),
            @Mapping(target = "addressId", source = "address.id")
    })
    CompetitionDTO toDTOList(Competition competition);

    List<CompetitionDTO> toDTOList(List<Competition> competition);

}
