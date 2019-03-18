package com.daniel.competitions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Competition extends AbstractEntityId {

    @OneToOne(cascade = CascadeType.ALL)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private LocalDateTime dateTime;


    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    List<CompetitionTeams> competitionTeams;



}
