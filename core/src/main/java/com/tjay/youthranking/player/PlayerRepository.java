package com.tjay.youthranking.player;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@ApplicationScoped
public class PlayerRepository {
    private final List<Player> playerList = new ArrayList<>();

    public Optional<Player> getPlayerForId(String id) {
        // Here we will add a real database transaction, so we leave this code unsecure firstly
        return playerList.stream().filter(player -> player.getId().equals(id))
                .findFirst();
    }

    public Player createPlayer(Player player) {
        String playerId = "Player-" + UUID.randomUUID();
        Player playerToPersist = Player.builder()
                .id(playerId)
                .foreName(player.getForeName())
                .surName(player.getSurName())
                .build();
        playerList.add(playerToPersist);
        return getPlayerForId(playerId).orElseThrow(() -> new RuntimeException(
                format("Something very weird happend. A new created player with id %s is not findable", playerId)));
    }

    public void updatePlayer(Player player) {
        Optional<Player> playerToUpdate = getPlayerForId(player.getId());
        if (playerToUpdate.isPresent()) {
            playerToUpdate.get().setForeName(player.getForeName());
            playerToUpdate.get().setSurName(player.getSurName());
        }
    }
}
