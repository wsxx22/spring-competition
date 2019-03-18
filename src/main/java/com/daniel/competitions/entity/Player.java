package com.daniel.competitions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends AbstractEntityId {

    private String name;
    private String surname;
    private String pesel;
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_team")
    private Team team;

}
