package com.daniel.competitions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competition extends AbstractEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private LocalDate date;


    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    List<CompetitionTeams> competitionTeams;



}
