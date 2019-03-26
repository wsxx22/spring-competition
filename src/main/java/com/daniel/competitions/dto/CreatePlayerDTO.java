package com.daniel.competitions.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerDTO implements Serializable {

    @NotNull
    @Size(min = 2, max = 20, message = "Imie zawodnika musi miec co najmniej 2 znaki i co najwyzej 20")
    private String name;

    @NotNull
    @Size(min = 2, max = 20, message = "Nazwisko zawodnika musi miec co najmniej 2 znaki i co najwyzej 20")
    private String surname;

    @NotNull
    @Size(min = 11, max = 11, message = "Pesel zawodnika musi miec dokladnie 11 znakow")
    private String pesel;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private int age;

    private Long teamId;
}
