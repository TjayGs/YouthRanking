package com.tjay.youthranking.game.singlegame;

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
@Path("/singleGames")
public class SingleGameController {

    private final SingleGameService singleGameService;

    @POST
    @Produces(APPLICATION_JSON)
    public Response createSingleGame(SingleGame singleGame) {
        SingleGame createdSingleGame = singleGameService.saveSingleGame(singleGame);
        log.info("Created new SingleGame {}", createdSingleGame);
        return Response.ok(createdSingleGame).build();
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getSingleGameById(@PathParam("id") String id) {
        Optional<SingleGame> singleGameOptional = singleGameService.findSingleGameById(id);
        if (singleGameOptional.isPresent()) {
            log.info("Returning SingleGame {} for id {}", singleGameOptional.get(), id);
            return Response.ok(singleGameOptional.get()).build();
        } else {
            log.info("No SingleGame found for id {}", id);
            return Response.status(NOT_FOUND).build();
        }
    }
}
