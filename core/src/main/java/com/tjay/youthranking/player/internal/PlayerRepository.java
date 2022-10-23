package com.tjay.youthranking.player.internal;


import com.tjay.youthranking.player.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player, String> {
    @Override
    Optional<Player> findById(String uuid);

    Optional<Player> findPlayerByForeNameAndSurName(String foreName, String surName);

    @Override
    Player save(Player entity);
}
