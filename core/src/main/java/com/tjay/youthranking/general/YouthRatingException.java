package com.tjay.youthranking.general;

import lombok.Getter;

/**
 * A quite generic exception, but it contains an error code variable
 */
@Getter
public class YouthRatingException extends RuntimeException {

    private final YouthRatingErrorCodes youthRatingErrorCode;

    public YouthRatingException(String msg, YouthRatingErrorCodes youthRatingErrorCode) {
        super(msg);
        this.youthRatingErrorCode = youthRatingErrorCode;
    }
}