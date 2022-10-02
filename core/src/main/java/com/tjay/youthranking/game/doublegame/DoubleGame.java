package com.tjay.youthranking.game.doublegame;

import com.tjay.youthranking.game.Game;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class DoubleGame extends Game {
    private String redTeamPlayerIdOne;
    private String redTeamPlayerIdTwo;
    private String blueTeamPlayerIdOne;
    private String blueTeamPlayerIdTwo;
}
