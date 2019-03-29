package com.daniel.competitions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionTeamsDTO {

    private Long competitionId;

//    private TeamDTO team; TODO

    private Long teamId;
    private int points;

}
