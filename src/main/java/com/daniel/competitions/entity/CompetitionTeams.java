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
    @JoinColumn(name = "id_competition")
    private Competition competition;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_team")
    private Team team;

    private int points;

}
