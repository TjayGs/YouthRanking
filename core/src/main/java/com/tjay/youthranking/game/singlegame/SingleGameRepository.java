package com.tjay.youthranking.game.singlegame;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@ApplicationScoped
public class SingleGameRepository {
    private final List<SingleGame> singleGameList = new ArrayList<>();

    public SingleGame createSingleGame(SingleGame incomingSingleGame) {
        String singleGameId = "SingleGame-" + UUID.randomUUID();
        SingleGame singleGameToPersist = SingleGame.builder()
                .id(singleGameId)
                .redGoals(incomingSingleGame.getRedGoals())
                .blueGoals(incomingSingleGame.getBlueGoals())
                .playedAt(LocalDate.now())
                .redTeamPlayerId(incomingSingleGame.getRedTeamPlayerId())
                .blueTeamPlayerId(incomingSingleGame.getBlueTeamPlayerId())
                .build();
        singleGameList.add(singleGameToPersist);
        return findSingleGameById(singleGameId)
                .orElseThrow(() -> new RuntimeException(
                        format("Fresh created singleGame could not be found for id: %s", singleGameId)
                ));
    }

    public Optional<SingleGame> findSingleGameById(String id) {
        return singleGameList.stream()
                .filter(singleGame -> singleGame.getId().equals(id))
                .findFirst();
    }
}
