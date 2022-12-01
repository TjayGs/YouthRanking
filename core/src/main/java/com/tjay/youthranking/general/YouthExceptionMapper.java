package com.tjay.youthranking.general;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

import static javax.ws.rs.core.Response.Status.CONFLICT;

@Provider
@Slf4j
public class YouthExceptionMapper implements ExceptionMapper<YouthRatingException> {

    @Override
    public Response toResponse(YouthRatingException exception) {
        log.warn("A YouthRating exception happen", exception);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("messageErrorKey", exception.getErrorCode());
        return Response.status(CONFLICT).entity(responseMap).build();
    }
}