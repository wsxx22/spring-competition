package com.daniel.competitions.controller;

import com.daniel.competitions.dto.CompetitionDTO;
import com.daniel.competitions.mapper.CompetitionMapper;
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
    private CompetitionMapper competitionMapper;

    @Autowired
    public CompetitionController(CompetitionService competitionService, CompetitionMapper competitionMapper) {
        this.competitionService = competitionService;
        this.competitionMapper = competitionMapper;
    }

    @GetMapping("/all")
    public List<CompetitionDTO> findAll(CompetitionSpecification competitionSpecification,
                                        @PageableDefault(size = 5) Pageable pageable) {
        return competitionMapper.toDTOList(competitionService.findAll(competitionSpecification, pageable).getContent());
    }


}
