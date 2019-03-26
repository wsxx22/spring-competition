package com.daniel.competitions.service;

import com.daniel.competitions.dto.CreatePlayerDTO;
import com.daniel.competitions.dto.PlayerDTO;
import com.daniel.competitions.entity.Player;
import com.daniel.competitions.repository.PlayerRepository;
import com.daniel.competitions.specification.PlayerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;
    private TeamService teamService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, TeamService teamService) {
        this.playerRepository = playerRepository;
        this.teamService = teamService;
    }

    public Page<Player> findAll(PlayerSpecification playerSpecification, Pageable pageable) {
        return playerRepository.findAll(playerSpecification, pageable);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego gracza."));
    }

    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player update(Long id, PlayerDTO playerDTO) {
        Player player = findById(id);

        player.setName(playerDTO.getName());

        player.setSurname(playerDTO.getSurname());

        if (playerDTO.getTeamId() != null){
            player.setTeam(teamService.findById(playerDTO.getTeamId()));
        } else {
            player.setTeam(null);
        }

        return playerRepository.save(player);
    }




//    private PlayerDTO convertToDTO(Player player) {
//        return new PlayerDTO(
//                player.getId(),
//                player.getName(),
//                player.getSurname(),
//                player.getAge()
//        );
//    }
//
//    private List<PlayerDTO> convertToDTO (List<Player> playerList) {
//        return playerList.stream().map(pL -> convertToDTO(pL)).collect(Collectors.toList());
//    }
}
