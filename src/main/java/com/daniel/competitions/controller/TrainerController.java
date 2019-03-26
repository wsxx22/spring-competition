package com.daniel.competitions.controller;

import com.daniel.competitions.dto.TrainerDTO;
import com.daniel.competitions.entity.Trainer;
import com.daniel.competitions.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/all")
    public List<TrainerDTO> findAll() {
        return trainerService.findAll();
    }



}
