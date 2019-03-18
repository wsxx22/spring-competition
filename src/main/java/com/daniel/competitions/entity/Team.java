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
public class Team extends AbstractEntityId {

    private String name;
    private int totalPoints;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_trainer")
    private Trainer trainer;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_team")
    private List<Player> playerList;

}
