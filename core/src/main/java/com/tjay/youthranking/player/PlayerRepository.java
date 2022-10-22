package com.tjay.youthranking.player;


import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, String> {
    @Override
    Optional<Player> findById(String uuid);

    @Override
    Player save(Player entity);
}
