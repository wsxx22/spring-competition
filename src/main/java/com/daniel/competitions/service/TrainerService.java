package com.daniel.competitions.service;

import com.daniel.competitions.dto.TrainerDTO;
import com.daniel.competitions.entity.Trainer;
import com.daniel.competitions.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<TrainerDTO> findAll() {
        return convertToDTO(trainerRepository.findAll());
    }

    private TrainerDTO convertToDTO(Trainer trainer){
        return new TrainerDTO(
                trainer.getId(),
                trainer.getName(),
                trainer.getSurname()
        );
    }

    private List<TrainerDTO> convertToDTO (List<Trainer> trainerList) {
        return trainerList.stream().map(tL -> convertToDTO(tL)).collect(Collectors.toList());
    }

}
