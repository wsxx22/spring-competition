package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.PlayerDTO;
import com.daniel.competitions.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper (componentModel = "spring")
public interface PlayerMapper {

    @Mappings({
        @Mapping(target = "teamId", source = "team.id")
    })
    PlayerDTO toDTO (Player player);

    List<PlayerDTO> toDTOList (List<Player> players);

}
