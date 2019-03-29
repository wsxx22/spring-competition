package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.CompetitionTeamsDTO;
import com.daniel.competitions.entity.CompetitionTeams;
import org.mapstruct.*;

import java.util.List;

@Mapper (componentModel = "spring",uses = {CompetitionMapper.class}, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CompetitionTeamsMapper {

    @Mappings({
            @Mapping(target = "competitionId", source = "competition.id"),
            @Mapping(target = "teamId", source = "team.id")
    })
    
    CompetitionTeamsDTO toDTO (CompetitionTeams competitionTeams);

    List<CompetitionTeams> toDTO (List<CompetitionTeams> competitionTeamsList);
}
