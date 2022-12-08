package com.tjay.youthranking.game.doublegame;

import org.springframework.data.repository.CrudRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.function.DoubleFunction;

@ApplicationScoped
public interface DoubleGameRepository extends CrudRepository<DoubleGame, String> {
    @Override
    Optional<DoubleGame> findById(String id);

    @Override
    DoubleGame save(DoubleGame doublegame);
}
