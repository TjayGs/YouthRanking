package com.tjay.youthranking.game.singlegame.internal;


import com.tjay.youthranking.game.singlegame.SingleGame;
import org.springframework.data.repository.CrudRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;


@ApplicationScoped
public interface SingleGameRepository extends CrudRepository<SingleGame, String> {
    Optional<SingleGame> findById(String id);

    @Override
    SingleGame save(SingleGame singleGame);
}
