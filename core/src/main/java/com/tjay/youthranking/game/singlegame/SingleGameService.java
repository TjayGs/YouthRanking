package com.tjay.youthranking.game.singlegame;

import com.tjay.youthranking.game.singlegame.internal.SingleGameRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class SingleGameService {
    private final SingleGameRepository singleGameRepository;

    Optional<SingleGame> findSingleGameById(String id) {
        return singleGameRepository.findById(id);
    }

    SingleGame saveSingleGame(SingleGame singleGame) {
        return singleGameRepository.save(singleGame);
    }
}