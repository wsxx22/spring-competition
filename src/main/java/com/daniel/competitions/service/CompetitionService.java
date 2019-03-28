package com.daniel.competitions.service;

import com.daniel.competitions.dto.CompetitionTeamsDTO;
import com.daniel.competitions.dto.CompetitonDTO;
import com.daniel.competitions.entity.Competition;
import com.daniel.competitions.mapper.CompetitionTeamsMapper;
import com.daniel.competitions.repository.CompetitionRepository;
import com.daniel.competitions.specification.CompetitionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitionService {

    private CompetitionRepository competitionRepository;
    private CompetitionTeamsMapper competitionTeamsMapper;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository, CompetitionTeamsMapper competitionTeamsMapper) {
        this.competitionRepository = competitionRepository;
        this.competitionTeamsMapper = competitionTeamsMapper;
    }

    public List<Competition> findAll0() {
        return competitionRepository.findAll();
    }

    public Page<Competition> findAll(CompetitionSpecification competitionSpecification, Pageable pageable) {
        return competitionRepository.findAll(competitionSpecification, pageable);
    }

    public CompetitonDTO findById(Long id) {
        return competitionRepository.findById(id).get();
    }

    public List<CompetitionTeamsDTO> findAll () {

    }


}
