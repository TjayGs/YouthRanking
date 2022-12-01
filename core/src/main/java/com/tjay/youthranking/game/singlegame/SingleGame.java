package com.tjay.youthranking.game.singlegame;

import com.tjay.youthranking.game.Game;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class SingleGame extends Game {
    private String blueTeamPlayerId;
    private String redTeamPlayerId;
}
