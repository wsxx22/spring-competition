package com.daniel.competitions.controller;

import com.daniel.competitions.entity.Competition;
import com.daniel.competitions.service.CompetitionService;
import com.daniel.competitions.specification.CompetitionSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    private CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping("/all")
    public List<Competition> findAll(CompetitionSpecification competitionSpecification,
                                     @PageableDefault(size = 5) Pageable pageable) {
        return competitionService.findAll(competitionSpecification, pageable).getContent();
    }


}
