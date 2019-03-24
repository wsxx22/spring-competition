package com.daniel.competitions.service;

import com.daniel.competitions.dto.TeamDTO;
import com.daniel.competitions.entity.Team;
import com.daniel.competitions.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team update(Long id, TeamDTO teamDTO) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego teamu"));

        if (teamDTO.getName() != null) {
            team.setName(teamDTO.getName());
        }

        return teamRepository.save(team);
    }

    public Team findById (Long id) {
        return teamRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiej druzyny"));
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
