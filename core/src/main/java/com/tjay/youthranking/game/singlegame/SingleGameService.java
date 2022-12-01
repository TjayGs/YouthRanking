package com.tjay.youthranking.game.singlegame;

import com.tjay.youthranking.game.singlegame.internal.SingleGameRepository;
import com.tjay.youthranking.general.YouthRatingException;
import com.tjay.youthranking.player.PlayerService;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

import static com.tjay.youthranking.general.ErrorCodeConstants.ERROR_CODE_GIVEN_PLAYER_ID_DOES_NOT_EXISTS;
import static com.tjay.youthranking.general.ErrorCodeConstants.ERROR_CODE_SINGLEGAME_GOAL_COMBINATION_INVALID;
import static java.lang.String.format;

@ApplicationScoped
@RequiredArgsConstructor
public class SingleGameService {
    private final SingleGameRepository singleGameRepository;
    private final PlayerService playerService;

    Optional<SingleGame> findSingleGameById(String id) {
        return singleGameRepository.findById(id);
    }

    SingleGame saveSingleGame(SingleGame singleGame) {
        validateSingleGame(singleGame);
        return singleGameRepository.save(singleGame);
    }

    private void validateSingleGame(SingleGame singleGame) {
        validateGoalCombination(singleGame);
        validatePlayerExistence(singleGame.getRedTeamPlayerId());
        validatePlayerExistence(singleGame.getBlueTeamPlayerId());
    }

    private void validatePlayerExistence(String playerId) {
        if (playerService.findPlayerById(playerId).isEmpty()) {
            throw new YouthRatingException(format("Player ID %s does not exists", playerId), ERROR_CODE_GIVEN_PLAYER_ID_DOES_NOT_EXISTS);
        }
    }

    private void validateGoalCombination(SingleGame singleGame) {
        if (singleGame.getRedTeamGoals() == 6 && singleGame.getBlueTeamGoals() == 6) {
            return;
        }

        if (singleGame.getRedTeamGoals() == 7 && 0 <= singleGame.getBlueTeamGoals() && 6 > singleGame.getBlueTeamGoals()) {
            return;
        }

        if (singleGame.getBlueTeamGoals() == 7 && 0 <= singleGame.getRedTeamGoals() && 6 > singleGame.getRedTeamGoals()) {
            return;
        }

        throw new YouthRatingException(format("Given goal combination is not allowed for singlegame. BlueTeamGoal %s RedTeamGoal %s",
                                              singleGame.getBlueTeamGoals(),
                                              singleGame.getRedTeamGoals()),
                                       ERROR_CODE_SINGLEGAME_GOAL_COMBINATION_INVALID);
    }
}