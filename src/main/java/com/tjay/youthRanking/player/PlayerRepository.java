package com.tjay.youthRanking.player;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;


@JdbcRepository
public interface PlayerRepository extends CrudRepository<Player, Long> {
}
