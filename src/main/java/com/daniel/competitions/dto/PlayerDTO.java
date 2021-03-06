package com.daniel.competitions.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private Long teamId;
}
