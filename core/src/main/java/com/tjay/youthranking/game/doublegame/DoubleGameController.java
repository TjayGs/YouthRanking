package com.tjay.youthranking.game.doublegame;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
@Path("/doubleGames")
public class DoubleGameController {

    private final DoubleGameRepository doubleGameRepository;

    @POST
    @Produces(APPLICATION_JSON)
    public Response createDoubleGame(DoubleGame incomingDoubleGame) {
        DoubleGame createdDoubleGame = doubleGameRepository.createDoubleGame(incomingDoubleGame);
        log.info("Created new DoubleGame {}", createdDoubleGame);
        return Response.ok(createdDoubleGame).build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getDoubleGameById(@PathParam("id") String id) {
        Optional<DoubleGame> doubleGameOptional = doubleGameRepository.findDoubleGameById(id);
        if (doubleGameOptional.isPresent()) {
            log.info("Returning DoubleGame {} for id {}", doubleGameOptional.get(), id);
            return Response.ok(doubleGameOptional.get()).build();
        } else {
            log.info("No DoubleGame found for id {}", id);
            return Response.status(NOT_FOUND).build();
        }
    }
}
