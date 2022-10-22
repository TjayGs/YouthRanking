package com.tjay.youthranking.player.controller;

import com.tjay.youthranking.player.Player;
import com.tjay.youthranking.player.PlayerRepository;
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

    private final PlayerRepository playerRepository;

    @PUT
    @Consumes(APPLICATION_JSON)
    public void updatePlayer(Player player) {
        playerRepository.save(player);
        log.info("Updated Player: " + playerRepository.findById(player.getId()).toString());
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public Response getPlayerById(@PathParam("id") String id) {
        Optional<Player> playerOptional = playerRepository.findById(id);
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
        Player createdPlayer = playerRepository.save(player);
        log.info("Created new player {}", player);
        return Response.ok(createdPlayer).build();
    }
}
