package com.daniel.competitions.service;

import com.daniel.competitions.dto.CompetitionTeamsDTO;
import com.daniel.competitions.dto.CompetitionDTO;
import com.daniel.competitions.entity.Competition;
import com.daniel.competitions.entity.CompetitionTeams;
import com.daniel.competitions.mapper.CompetitionMapper;
import com.daniel.competitions.mapper.CompetitionTeamsMapper;
import com.daniel.competitions.repository.CompetitionRepository;
import com.daniel.competitions.specification.CompetitionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionService {

    private CompetitionRepository competitionRepository;
    private CompetitionTeamsMapper competitionTeamsMapper;
    private CompetitionMapper competitionMapper;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository,
                              CompetitionTeamsMapper competitionTeamsMapper,
                              CompetitionMapper competitionMapper) {
        this.competitionRepository = competitionRepository;
        this.competitionTeamsMapper = competitionTeamsMapper;
        this.competitionMapper = competitionMapper;
    }

    public Page<Competition> findAll(CompetitionSpecification competitionSpecification, Pageable pageable) {
        return competitionRepository.findAll(competitionSpecification, pageable);
    }

    public Competition findById(Long id) {
        return competitionRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma zawodów takim ID"));
    }


//    public List<Competition> findByDate (LocalDate date) {
//        return competitionRepository.findByDateLike(date);
//    }




}
