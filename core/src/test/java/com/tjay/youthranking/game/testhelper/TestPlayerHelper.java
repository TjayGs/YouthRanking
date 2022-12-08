package com.tjay.youthranking.game.testhelper;

import com.tjay.youthranking.player.Player;
import io.restassured.http.ContentType;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

import static io.restassured.RestAssured.given;

@ApplicationScoped
public class TestPlayerHelper {
    public Player createPlayer() {
        Player player = Player.builder().foreName(UUID.randomUUID().toString()).surName(UUID.randomUUID().toString()).build();
        return given()
        .contentType(ContentType.JSON)
        .body(player)
        .when()
        .post("/players")
        .thenReturn().body().as(Player.class);
    }
}