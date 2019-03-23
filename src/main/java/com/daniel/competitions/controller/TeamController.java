package com.daniel.competitions.controller;

import com.daniel.competitions.dto.TeamDTO;
import com.daniel.competitions.mapper.TeamMapper;
import com.daniel.competitions.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private TeamService teamService;
    private TeamMapper teamMapper;

    @Autowired
    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
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

}
