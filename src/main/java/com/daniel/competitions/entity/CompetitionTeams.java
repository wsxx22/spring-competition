package com.daniel.competitions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionTeams implements Serializable {


    @Id
    @ManyToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @Id
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    private int points;

}
