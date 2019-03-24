package com.daniel.competitions.service;

import com.daniel.competitions.dto.CreatePlayerDTO;
import com.daniel.competitions.dto.PlayerDTO;
import com.daniel.competitions.entity.Player;
import com.daniel.competitions.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego gracza w tej druzynie."));
    }

    public void deletePlayerById(Long id) {
        playerRepository.deleteById(id);
    }

    public Player addPlayer(Player newPlayerDTO) {
        return playerRepository.save(newPlayerDTO);
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
