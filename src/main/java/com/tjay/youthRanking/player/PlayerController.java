package com.tjay.youthRanking.player;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Put;
import jakarta.inject.Inject;

import static java.lang.String.format;

/**
 * This controller will handle everything around the {@link Player} entity
 */
@Controller("/players")
public class PlayerController {

    private final PlayerRepository playerRepository;

    @Inject
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Get("{id}")
    public Player findById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(format("no player exists with given id %s", id)));
    }

    @Put
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
}
