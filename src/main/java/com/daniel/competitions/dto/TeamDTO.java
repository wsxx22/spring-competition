package com.daniel.competitions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO implements Serializable {

    private Long id;
    private String name;
    private int totalPoints;
    private Long trainerId;

    private List<PlayerDTO> players;

}
