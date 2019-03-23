package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.TeamDTO;
import com.daniel.competitions.entity.Team;
import com.daniel.competitions.service.TrainerService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlayerMapper.class}, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public abstract class TeamMapper {

    @Autowired
    protected TrainerService trainerService;

    @Mappings({
            @Mapping(target = "trainerId", source = "trainer.id")
    })
    public abstract TeamDTO toDTO (Team team);

    public abstract List<TeamDTO> toDTOList (List<Team> teams);


    @Mapping(target = "trainer", expression = "java(trainerService.findById(teamDTO.getTrainerId()))")
    public abstract Team toEntity (TeamDTO teamDTO);
}
