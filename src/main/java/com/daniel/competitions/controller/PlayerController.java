package com.daniel.competitions.controller;

import com.daniel.competitions.dto.CreatePlayerDTO;
import com.daniel.competitions.dto.PlayerDTO;
import com.daniel.competitions.mapper.PlayerMapper;
import com.daniel.competitions.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private PlayerMapper playerMapper;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping("/all")
    public List<PlayerDTO> findAll() {
        return playerMapper.toDTOList(playerService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public void deletePlayerById (@PathVariable Long id) {
        playerService.deletePlayerById(id);
    }


    @PostMapping("/add")
    public CreatePlayerDTO addPlayer (@RequestBody CreatePlayerDTO newPlayerDTO) {
        return playerMapper.toCreatePlayerDTO(playerService.addPlayer(playerMapper.createPlayerDTOToEntity(newPlayerDTO)));
    }

    @PutMapping("/update/{id}")
    public PlayerDTO update (@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        return playerMapper.toDTO(playerService.update(id, playerDTO));

    }


}
