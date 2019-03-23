package com.daniel.competitions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trainer extends AbstractEntity {

    private String name;
    private String surname;
    private int age;

}
