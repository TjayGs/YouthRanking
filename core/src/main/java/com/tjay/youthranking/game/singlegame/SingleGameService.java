package com.tjay.youthranking.game.singlegame;

import com.tjay.youthranking.game.GameValidator;
import com.tjay.youthranking.game.singlegame.internal.SingleGameRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class SingleGameService {
    private final SingleGameRepository singleGameRepository;
    private final GameValidator gameValidator;

    Optional<SingleGame> findSingleGameById(String id) {
        return singleGameRepository.findById(id);
    }

    SingleGame saveSingleGame(SingleGame singleGame) {
        validateSingleGame(singleGame);
        return singleGameRepository.save(singleGame);
    }

    private void validateSingleGame(SingleGame singleGame) {
        gameValidator.validateGoalsCombination(singleGame);
        gameValidator.validatePlayerExistence(singleGame.getRedTeamPlayerId());
        gameValidator.validatePlayerExistence(singleGame.getBlueTeamPlayerId());
    }
}