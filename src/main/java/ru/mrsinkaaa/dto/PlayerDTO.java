package ru.mrsinkaaa.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private int id;
    private String name;
    private int currentScore;
    private List<Integer> setScores;
    private boolean isServing;

    public PlayerDTO(int id, String name) {
        this.id = id;
        this.name = name;
        this.setScores = new ArrayList<>();
    }
}
