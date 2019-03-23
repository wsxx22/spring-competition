package com.daniel.competitions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Team extends AbstractEntity {

    private String name;
    private int totalPoints;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private List<Player> players;

}
