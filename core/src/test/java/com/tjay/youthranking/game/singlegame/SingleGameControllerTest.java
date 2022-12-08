package com.tjay.youthranking.game.singlegame;

import com.tjay.youthranking.game.testhelper.TestPlayerHelper;
import com.tjay.youthranking.player.Player;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.UUID;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class SingleGameControllerTest {

    @Inject
    private TestPlayerHelper testPlayerHelper;

    @Test
    public void testCreatingSingleGameHappyPath() {
        Player randomPlayer = testPlayerHelper.createPlayer();
        SingleGame singleGame = SingleGame.builder().blueTeamPlayerId(randomPlayer.getId()).redTeamPlayerId(randomPlayer.getId()).blueTeamGoals(6).redTeamGoals(6).build();
        SingleGame createdSingleGame = given()
        .body(singleGame)
        .contentType(ContentType.JSON)
        .when().post("/singleGames")
        .then().statusCode(200).extract().body().as(SingleGame.class);

        assert createdSingleGame.getPlayedAt().equals(LocalDate.now());
        assert createdSingleGame.getBlueTeamPlayerId().equals(randomPlayer.getId());
        assert createdSingleGame.getRedTeamPlayerId().equals(randomPlayer.getId());
        assert createdSingleGame.getBlueTeamGoals() == 6;
        assert createdSingleGame.getRedTeamGoals() == 6;
        assert !createdSingleGame.getId().isEmpty();
    }

    @Test
    public void testCreatingSingleGameWithRedWin() {
        Player randomPlayer = testPlayerHelper.createPlayer();
        SingleGame singleGame = SingleGame.builder().blueTeamPlayerId(randomPlayer.getId()).redTeamPlayerId(randomPlayer.getId()).blueTeamGoals(0).redTeamGoals(7).build();
        SingleGame createdSingleGame = given()
        .body(singleGame)
        .contentType(ContentType.JSON)
        .when().post("/singleGames")
        .then().statusCode(200).extract().body().as(SingleGame.class);

        assert createdSingleGame.getPlayedAt().equals(LocalDate.now());
        assert createdSingleGame.getBlueTeamPlayerId().equals(randomPlayer.getId());
        assert createdSingleGame.getRedTeamPlayerId().equals(randomPlayer.getId());
        assert createdSingleGame.getBlueTeamGoals() == 0;
        assert createdSingleGame.getRedTeamGoals() == 7;
        assert !createdSingleGame.getId().isEmpty();
    }

    @Test
    public void testCreatingSingleGameWithBlueWin() {
        Player randomPlayer = testPlayerHelper.createPlayer();
        SingleGame singleGame = SingleGame.builder().blueTeamPlayerId(randomPlayer.getId()).redTeamPlayerId(randomPlayer.getId()).blueTeamGoals(7).redTeamGoals(5).build();
        SingleGame createdSingleGame = given()
        .body(singleGame)
        .contentType(ContentType.JSON)
        .when().post("/singleGames")
        .then().statusCode(200).extract().body().as(SingleGame.class);

        assert createdSingleGame.getPlayedAt().equals(LocalDate.now());
        assert createdSingleGame.getBlueTeamPlayerId().equals(randomPlayer.getId());
        assert createdSingleGame.getRedTeamPlayerId().equals(randomPlayer.getId());
        assert createdSingleGame.getBlueTeamGoals() == 7;
        assert createdSingleGame.getRedTeamGoals() == 5;
        assert !createdSingleGame.getId().isEmpty();
    }

    @Test
    public void testSingleGamePlayerMustExists() {
        SingleGame singleGame = SingleGame.builder().blueTeamPlayerId("NotExist").redTeamPlayerId("NotExist").blueTeamGoals(7).redTeamGoals(5).build();
        JsonPath errorCode = given()
        .body(singleGame)
        .contentType(ContentType.JSON)
        .when().post("/singleGames")
        .then().statusCode(409).extract().body().jsonPath();

        assert errorCode.get("messageErrorKey").equals("0004");
    }

    @Test
    public void testSingleGameMoreThanEightGoalsNotAllowed() {
        Player randomPlayer = testPlayerHelper.createPlayer();
        SingleGame singleGame = SingleGame.builder().blueTeamPlayerId(randomPlayer.getId()).redTeamPlayerId(randomPlayer.getId()).blueTeamGoals(8).redTeamGoals(5).build();
        String messageErrorKey = given()
        .body(singleGame)
        .contentType(ContentType.JSON)
        .when().post("/singleGames")
        .then().statusCode(409).extract().body().jsonPath().get("messageErrorKey");

        assert messageErrorKey.equals("0003");
    }
}