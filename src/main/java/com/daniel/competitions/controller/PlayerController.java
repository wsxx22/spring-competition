package com.daniel.competitions.controller;

import com.daniel.competitions.dto.CreatePlayerDTO;
import com.daniel.competitions.dto.PlayerDTO;
import com.daniel.competitions.mapper.PlayerMapper;
import com.daniel.competitions.service.PlayerService;
import com.daniel.competitions.specification.PlayerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;
    private PlayerMapper playerMapper;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerMapper playerMapper) {
        this.playerService = playerService;
        this.playerMapper = playerMapper;
    }

    @GetMapping
    public List<PlayerDTO> findAll(PlayerSpecification playerSpecification,
                                   @PageableDefault(size = 20) Pageable pageable) {
        return playerMapper.toDTO(playerService.findAll(playerSpecification, pageable).getContent());
    }

    @PostMapping
    public CreatePlayerDTO addPlayer (@Valid @RequestBody CreatePlayerDTO newPlayerDTO) {
        return playerMapper.toCreatePlayerDTO(playerService.addPlayer(playerMapper.createPlayerDTOToEntity(newPlayerDTO)));
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById (@PathVariable Long id) {
        playerService.deletePlayerById(id);
    }

    @PutMapping("/update/{id}")
    public PlayerDTO update (@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        return playerMapper.toDTO(playerService.update(id, playerDTO));
    }


}
