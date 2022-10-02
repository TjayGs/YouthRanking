package com.tjay.youthranking.game.singlegame;

import com.tjay.youthranking.game.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SingleGame extends Game {
    private String blueTeamPlayerId;
    private String redTeamPlayerId;
}
