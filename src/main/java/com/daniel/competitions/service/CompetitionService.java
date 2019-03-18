package com.daniel.competitions.service;

import com.daniel.competitions.entity.Competition;
import com.daniel.competitions.repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }


}
