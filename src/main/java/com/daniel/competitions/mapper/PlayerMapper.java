package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.CreatePlayerDTO;
import com.daniel.competitions.dto.PlayerDTO;
import com.daniel.competitions.entity.Player;
import com.daniel.competitions.entity.Team;
import com.daniel.competitions.service.TeamService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper (componentModel = "spring")
public abstract class PlayerMapper {

    @Autowired
    protected TeamService teamService;

//    CreatePlayerDTO createPlayerDTO;
//
//    @Autowired
//    public PlayerMapper(TeamService teamService, CreatePlayerDTO createPlayerDTO) {
//        this.teamService = teamService;
//        this.createPlayerDTO = createPlayerDTO;
//    }

    @Mappings({
        @Mapping(target = "teamId", source = "team.id")
    })
    public abstract PlayerDTO toDTO (Player player);

    public abstract List<PlayerDTO> toDTO(List<Player> players);

    @Mappings({
            @Mapping(target = "teamId", source = "team.id")
    })
    public abstract CreatePlayerDTO toCreatePlayerDTO (Player player);

    public Player createPlayerDTOToEntity(CreatePlayerDTO createPlayerDTO) {
        if ( createPlayerDTO == null ) {
            return null;
        }

        Player player = new Player();

        player.setName( createPlayerDTO.getName() );
        player.setSurname( createPlayerDTO.getSurname() );
        player.setPesel( createPlayerDTO.getPesel() );
        player.setAge( createPlayerDTO.getAge() );

        if (createPlayerDTO.getTeamId() != null) {
            player.setTeam( teamService.findById(createPlayerDTO.getTeamId()) );
        }

        return player;
    }

//    private Player checkTeamId (CreatePlayerDTO createPlayerDTO) {
//        if ( (teamService.findById(createPlayerDTO.getTeamId())) == null ) {
//            return new Player(createPlayerDTO.getName(), createPlayerDTO.getSurname(), createPlayerDTO.getPesel(), createPlayerDTO.getAge());
//        } else {
//            return new Player(
//                    createPlayerDTO.getName(),
//                    createPlayerDTO.getSurname(),
//                    createPlayerDTO.getPesel(),
//                    createPlayerDTO.getAge(),
//                    ( teamService.findById( createPlayerDTO.getTeamId() ) )
//            );
//        }
//    }

}
