package com.tjay.youthranking.general;

import lombok.Getter;

/**
 * Class will contain all error codes which could be thrown to the caller
 */
public enum YouthRatingErrorCodes {
    FORENAME_OR_SURNAME_MUST_NOT_BE_EMPTY("0001"),
    FORENAME_AND_SURNAME_COMBINATION_NOT_UNIQUE("0002"),
    GAME_GOAL_COMBINATION_INVALID("0003"),
    GIVEN_PLAYER_ID_DOES_NOT_EXISTS("0004");


    @Getter
    private final String errorCode;

    YouthRatingErrorCodes(String errorCode) {
        this.errorCode = errorCode;
    }
}