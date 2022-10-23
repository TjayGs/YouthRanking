package com.tjay.youthranking.player;

import lombok.Getter;

/**
 * A quite generic exception, but it contains an error code variable
 */
@Getter
public class YouthRatingException extends RuntimeException {

    private final String errorCode;

    public YouthRatingException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}