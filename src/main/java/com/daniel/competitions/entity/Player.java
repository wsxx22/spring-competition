package com.daniel.competitions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player extends AbstractEntity {

    private String name;
    private String surname;
    private String pesel;
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    public Player(String name, String surname, String pesel, int age) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.age = age;
    }

    public Player(String name, String surname, int age, Team team) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.team = team;
    }
}
