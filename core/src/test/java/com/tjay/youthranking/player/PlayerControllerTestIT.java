package com.tjay.youthranking.player;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.UUID;

import static com.tjay.youthranking.general.YouthRatingErrorCodes.GIVEN_PLAYER_ID_DOES_NOT_EXISTS;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

@QuarkusTest
public class PlayerControllerTestIT {

    @Inject
    private com.tjay.youthranking.game.testhelper.TestPlayerHelper testPlayerHelper;

    @Test
    public void updatingPlayerShouldBePossible() {
        // Create Player
        var newPlayer = testPlayerHelper.createPlayer();

        var foreName = UUID.randomUUID().toString();
        var surName = UUID.randomUUID().toString();
        newPlayer.setForeName(foreName);
        newPlayer.setSurName(surName);

        given()
            .body(newPlayer)
            .contentType(JSON)
            .when()
            .put("/players")
            .then().statusCode(204);

        var updatedPlayer = given().when()
            .get("/players/{id}", newPlayer.getId())
            .then().statusCode(200).extract().body().as(Player.class);

        assert updatedPlayer.getSurName().equals(surName);
        assert updatedPlayer.getForeName().equals(foreName);
    }

    @Test
    public void updatingPlayerWithoutIdShouldNotWork() {
        // Create Player
        var newPlayer = testPlayerHelper.createPlayer();

        var foreName = UUID.randomUUID().toString();
        var surName = UUID.randomUUID().toString();
        newPlayer.setForeName(foreName);
        newPlayer.setSurName(surName);
        newPlayer.setId("");

        var errorCode = given()
            .body(newPlayer)
            .contentType(JSON)
            .when()
            .put("/players")
            .then().statusCode(409).extract().body().path("messageErrorKey");
        assert errorCode.equals(GIVEN_PLAYER_ID_DOES_NOT_EXISTS.getErrorCode());
    }
}