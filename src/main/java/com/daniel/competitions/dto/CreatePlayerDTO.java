package com.daniel.competitions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerDTO {

    private Long id;
    private String name;
    private String surname;
    private String pesel;
    private int age;
    private Long teamId;
}
