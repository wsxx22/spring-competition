package com.daniel.competitions.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

}
