package com.daniel.competitions.controller;

import com.daniel.competitions.dto.PlayerDTO;
import com.daniel.competitions.dto.TeamDTO;
import com.daniel.competitions.mapper.PlayerMapper;
import com.daniel.competitions.mapper.TeamMapper;
import com.daniel.competitions.service.PlayerService;
import com.daniel.competitions.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private TeamService teamService;
    private TeamMapper teamMapper;
    private PlayerService playerService;
    private PlayerMapper playerMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper, PlayerService playerService, PlayerMapper playerMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/all")
    public List<TeamDTO> findAll() {
        return teamMapper.toDTOList(teamService.findAll());
    }

    @PatchMapping("/{id}")
    public TeamDTO update (@PathVariable Long id, @RequestBody TeamDTO teamDTO) {
        return teamMapper.toDTO(teamService.update(id, teamDTO));
    }

    @PostMapping ("/save")
    public TeamDTO addTeam (@RequestBody TeamDTO teamDTO){
        return teamMapper.toDTO(teamService.save(teamMapper.toEntity(teamDTO)));
    }

    @GetMapping("/{name}/all")
    public List<PlayerDTO> findPlayersByTeamName (@PathVariable String name) {
        return playerMapper.toDTO(playerService.findAll()
                .stream()
                .filter(player -> player.getTeam().getName().equals(name))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{name}/{id}")
    public PlayerDTO findPlayerByTeamNameAndPlayerId (
            @PathVariable String name,
            @PathVariable Long id) {
        return playerMapper.toDTO(playerService.findById(id));
    }

}
