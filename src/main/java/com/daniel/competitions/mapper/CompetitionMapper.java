package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.CompetitionDTO;
import com.daniel.competitions.entity.Competition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper (componentModel = "spring")
public interface CompetitionMapper {

    @Mappings({
            @Mapping(target = "categoryId", source = "category"),
            @Mapping(target = "addressId", source = "address")
    })
    CompetitionDTO toDTO (Competition competition);

}
