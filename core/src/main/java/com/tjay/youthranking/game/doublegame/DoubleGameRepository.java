package com.tjay.youthranking.game.doublegame;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@ApplicationScoped
public class DoubleGameRepository {
    private final List<DoubleGame> doubleGameList = new ArrayList<>();

    public DoubleGame createDoubleGame(DoubleGame incomingDoubleGame) {
        String doubleGameId = "DoubleGame-" + UUID.randomUUID();
        DoubleGame doubleGameToPersist = DoubleGame.builder()
                .id(doubleGameId)
                .redTeamGoals(incomingDoubleGame.getRedTeamGoals())
                .blueTeamGoals(incomingDoubleGame.getBlueTeamGoals())
                .playedAt(LocalDate.now())
                .redTeamPlayerIdOne(incomingDoubleGame.getRedTeamPlayerIdOne())
                .redTeamPlayerIdTwo(incomingDoubleGame.getRedTeamPlayerIdTwo())
                .blueTeamPlayerIdOne(incomingDoubleGame.getBlueTeamPlayerIdOne())
                .blueTeamPlayerIdTwo(incomingDoubleGame.getBlueTeamPlayerIdTwo())
                .build();
        doubleGameList.add(doubleGameToPersist);
        return findDoubleGameById(doubleGameId)
                .orElseThrow(() -> new RuntimeException(
                        format("Fresh created DoubleGame could not be found for id: %s", doubleGameId)
                ));
    }

    public Optional<DoubleGame> findDoubleGameById(String id) {
        return doubleGameList.stream()
                .filter(doubleGame -> doubleGame.getId().equals(id))
                .findFirst();
    }
}
