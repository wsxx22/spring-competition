package com.daniel.competitions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionDTO {

    private Long id;
    private Long categoryId;
    private Long addressId;
    private LocalDate date;

    private List<CompetitionTeamsDTO> competitionTeams;
}
