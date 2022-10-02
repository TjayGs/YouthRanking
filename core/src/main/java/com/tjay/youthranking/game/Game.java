package com.tjay.youthranking.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Game {
    private String id;
    private int redGoals;
    private int blueGoals;
    private LocalDate playedAt;
}
