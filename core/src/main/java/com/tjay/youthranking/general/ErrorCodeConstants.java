package com.tjay.youthranking.general;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * Class will contain all error codes which could be thrown to the caller
 */
@NoArgsConstructor(access = PRIVATE)
public class ErrorCodeConstants {
    public static final String ERROR_CODE_FORENAME_OR_SURNAME_MUST_NOT_BE_EMPTY = "0001";
    public static final String ERROR_CODE_FORENAME_AND_SURNAME_COMBINATION_NOT_UNIQUE = "0002";
    public static final String ERROR_CODE_GAME_GOAL_COMBINATION_INVALID = "0003";
    public static final String ERROR_CODE_GIVEN_PLAYER_ID_DOES_NOT_EXISTS = "0004";
}