package com.tjay.youthranking.game.doublegame;

import com.tjay.youthranking.game.testhelper.TestPlayerHelper;
import com.tjay.youthranking.player.Player;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.time.LocalDate;

import static com.tjay.youthranking.general.YouthRatingErrorCodes.GAME_GOAL_COMBINATION_INVALID;
import static io.restassured.RestAssured.given;

@QuarkusTest
public class DoubleGameControllerTestIT {

    @Inject
    private TestPlayerHelper testPlayerHelper;

    @Test
    public void testCreatingDoubleGameHappyPathTie() {
        Player playerOne = testPlayerHelper.createPlayer();
        Player playerTwo = testPlayerHelper.createPlayer();
        DoubleGame doubleGame = DoubleGame.builder()
            .blueTeamPlayerIdOne(playerOne.getId())
            .blueTeamPlayerIdTwo(playerTwo.getId())
            .redTeamPlayerIdOne(playerOne.getId())
            .redTeamPlayerIdTwo(playerTwo.getId())
            .blueTeamGoals(6)
            .redTeamGoals(6)
            .build();

        DoubleGame createdDoubleGame = given()
            .body(doubleGame)
            .contentType(ContentType.JSON)
            .when().post("/doubleGames")
            .then().statusCode(200).extract().body().as(DoubleGame.class);

        assert createdDoubleGame.getPlayedAt().equals(LocalDate.now());
        assert createdDoubleGame.getBlueTeamPlayerIdOne().equals(playerOne.getId());
        assert createdDoubleGame.getBlueTeamPlayerIdTwo().equals(playerTwo.getId());
        assert createdDoubleGame.getRedTeamPlayerIdOne().equals(playerOne.getId());
        assert createdDoubleGame.getRedTeamPlayerIdTwo().equals(playerTwo.getId());
        assert createdDoubleGame.getBlueTeamGoals() == 6;
        assert createdDoubleGame.getRedTeamGoals() == 6;
        assert !createdDoubleGame.getId().isEmpty();
    }

    @Test
    public void creatingDoubleGameWithZeroZeroShouldNotWork() {
        Player playerOne = testPlayerHelper.createPlayer();
        Player playerTwo = testPlayerHelper.createPlayer();
        DoubleGame doubleGame = DoubleGame.builder()
            .blueTeamPlayerIdOne(playerOne.getId())
            .blueTeamPlayerIdTwo(playerTwo.getId())
            .redTeamPlayerIdOne(playerOne.getId())
            .redTeamPlayerIdTwo(playerTwo.getId())
            .blueTeamGoals(0)
            .redTeamGoals(0)
            .build();

        String errorCode = given()
            .body(doubleGame)
            .contentType(ContentType.JSON)
            .when().post("/doubleGames")
        .then().statusCode(409).extract().body().path("messageErrorKey");

        assert errorCode.equals(GAME_GOAL_COMBINATION_INVALID.getErrorCode());
    }

    @Test
    public void creatingDoubleGameWithSevenToMinusOneShouldNotWork() {
        Player playerOne = testPlayerHelper.createPlayer();
        Player playerTwo = testPlayerHelper.createPlayer();
        DoubleGame doubleGame = DoubleGame.builder()
        .blueTeamPlayerIdOne(playerOne.getId())
        .blueTeamPlayerIdTwo(playerTwo.getId())
        .redTeamPlayerIdOne(playerOne.getId())
        .redTeamPlayerIdTwo(playerTwo.getId())
        .blueTeamGoals(7)
        .redTeamGoals(-1)
        .build();

        String errorCode = given()
        .body(doubleGame)
        .contentType(ContentType.JSON)
        .when().post("/doubleGames")
        .then().statusCode(409).extract().body().path("messageErrorKey");

        assert errorCode.equals(GAME_GOAL_COMBINATION_INVALID.getErrorCode());
    }

    @Test
    public void testCreatingDoubleGameHappyPathWin() {
        Player playerOne = testPlayerHelper.createPlayer();
        Player playerTwo = testPlayerHelper.createPlayer();
        DoubleGame doubleGame = DoubleGame.builder()
        .blueTeamPlayerIdOne(playerOne.getId())
        .blueTeamPlayerIdTwo(playerTwo.getId())
        .redTeamPlayerIdOne(playerOne.getId())
        .redTeamPlayerIdTwo(playerTwo.getId())
        .blueTeamGoals(7)
        .redTeamGoals(5)
        .build();

        DoubleGame createdDoubleGame = given()
        .body(doubleGame)
        .contentType(ContentType.JSON)
        .when().post("/doubleGames")
        .then().statusCode(200).extract().body().as(DoubleGame.class);

        assert createdDoubleGame.getPlayedAt().equals(LocalDate.now());
        assert createdDoubleGame.getBlueTeamPlayerIdOne().equals(playerOne.getId());
        assert createdDoubleGame.getBlueTeamPlayerIdTwo().equals(playerTwo.getId());
        assert createdDoubleGame.getRedTeamPlayerIdOne().equals(playerOne.getId());
        assert createdDoubleGame.getRedTeamPlayerIdTwo().equals(playerTwo.getId());
        assert createdDoubleGame.getBlueTeamGoals() == 7;
        assert createdDoubleGame.getRedTeamGoals() == 5;
        assert !createdDoubleGame.getId().isEmpty();
    }
}