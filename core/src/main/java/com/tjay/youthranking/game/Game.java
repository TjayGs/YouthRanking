package com.tjay.youthranking.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass // Allows this abstract class be used for Subclass-Entities
public abstract class Game {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
    strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private int redTeamGoals;
    private int blueTeamGoals;
    private LocalDate playedAt;
}
