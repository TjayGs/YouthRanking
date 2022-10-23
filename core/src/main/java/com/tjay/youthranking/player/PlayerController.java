package com.tjay.youthranking.player;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/players")
@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class PlayerController {

    private final PlayerService playerService;

    @PUT
    @Consumes(APPLICATION_JSON)
    public void updatePlayer(Player player) {
        playerService.save(player);
        log.info("Updated Player: " + playerService.findPlayerById(player.getId()).toString());
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getPlayerById(@PathParam("id") String id) {
        Optional<Player> playerOptional = playerService.findPlayerById(id);
        if (playerOptional.isPresent()) {
            log.info("Returning player {} for id {}", playerOptional.get(), id);
            return Response.ok(playerOptional.get()).build();
        } else {
            log.info("No Player found for id {}", id);
            return Response.status(NOT_FOUND).build();
        }
    }

    @POST
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public Response createPlayer(Player player) {
        Player createdPlayer = playerService.save(player);
        log.info("Created new player {}", createdPlayer);
        return Response.ok(createdPlayer).build();
    }
}
