package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.CompetitionTeamsDTO;
import com.daniel.competitions.entity.CompetitionTeams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface CompetitionTeamsMapper {

    @Mappings({
            @Mapping(target = "competitionId", source = "competition.id"),
            @Mapping(target = "teamId", source = "team.id")
    })
    CompetitionTeamsDTO toDTO (CompetitionTeams competitionTeams);

    List<CompetitionTeams> toDTO (List<CompetitionTeams> competitionTeamsList);
}
