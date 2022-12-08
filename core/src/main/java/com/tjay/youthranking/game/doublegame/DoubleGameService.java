package com.tjay.youthranking.game.doublegame;

import com.tjay.youthranking.game.GameValidator;
import lombok.RequiredArgsConstructor;
import com.tjay.youthranking.game.doublegame.DoubleGameRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class DoubleGameService {
    private final DoubleGameRepository doubleGameRepository;
    private final GameValidator gameValidator;

    Optional<DoubleGame> findDoubleGameById(String id) {
        return doubleGameRepository.findById(id);
    }

    DoubleGame saveDoubleGame(DoubleGame doubleGame) {
        validateDoubleGame(doubleGame);

        gameValidator.validateGoalsCombination(doubleGame);
        return doubleGameRepository.save(doubleGame);
    }

    private void validateDoubleGame(DoubleGame doubleGame) {
        gameValidator.validateGoalsCombination(doubleGame);
        gameValidator.validatePlayerExistence(doubleGame.getBlueTeamPlayerIdOne());
        gameValidator.validatePlayerExistence(doubleGame.getBlueTeamPlayerIdTwo());
        gameValidator.validatePlayerExistence(doubleGame.getRedTeamPlayerIdOne());
        gameValidator.validatePlayerExistence(doubleGame.getRedTeamPlayerIdTwo());
    }
}