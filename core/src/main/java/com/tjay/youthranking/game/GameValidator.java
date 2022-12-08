package com.tjay.youthranking.game;

import com.tjay.youthranking.general.YouthRatingException;
import com.tjay.youthranking.player.PlayerService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

import static com.tjay.youthranking.general.YouthRatingErrorCodes.GAME_GOAL_COMBINATION_INVALID;
import static com.tjay.youthranking.general.YouthRatingErrorCodes.GIVEN_PLAYER_ID_DOES_NOT_EXISTS;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class GameValidator {
    private final PlayerService playerService;

    public void validateGoalsCombination(Game game) {
        if ((game.getRedTeamGoals() == 6 && game.getBlueTeamGoals() == 6)
            || (game.getRedTeamGoals() == 7 && 0 <= game.getBlueTeamGoals() && 6 > game.getBlueTeamGoals())
            || (game.getBlueTeamGoals() == 7 && 0 <= game.getRedTeamGoals() && 6 > game.getRedTeamGoals())) {
            return;
        }

        throw new YouthRatingException(format("Given goal combination is not allowed for Game. BlueTeamGoal %s RedTeamGoal %s",
            game.getBlueTeamGoals(),
            game.getRedTeamGoals()),
            GAME_GOAL_COMBINATION_INVALID);
    }

    public void validatePlayerExistence(String playerId) {
        if (playerService.findPlayerById(playerId).isEmpty()) {
            throw new YouthRatingException(format("Player ID %s does not exists", playerId), GIVEN_PLAYER_ID_DOES_NOT_EXISTS);
        }
    }
}