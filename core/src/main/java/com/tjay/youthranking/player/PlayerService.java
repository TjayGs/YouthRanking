package com.tjay.youthranking.player;

import com.tjay.youthranking.player.internal.PlayerRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

import static com.tjay.youthranking.general.ErrorCodeConstants.ERROR_CODE_FORENAME_OR_SURNAME_MUST_NOT_BE_EMPTY;

/**
 * This is the class which deals as only access to the db.
 * It will perform validations and clean ups automatically
 */
@ApplicationScoped
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public Optional<Player> findPlayerById(String id) {
        return playerRepository.findById(id);
    }


    /**
    * Before saving the Player, it will be cleaned up
    */
    public Player save(Player player) {
        Player cleanedPlayer = cleanUpPlayer(player);
        validatePlayer(player);
        return playerRepository.save(cleanedPlayer);
    }

    private void validatePlayer(Player player) {
        // foreName or surName must not be empty
        if (player.getForeName().isBlank() || player.getSurName().isBlank()) {
            throw new YouthRatingException("Forename or Surname must not be empty for given player: " + player,
                                           ERROR_CODE_FORENAME_OR_SURNAME_MUST_NOT_BE_EMPTY);
        }
    }

    /**
     * Method will cleanUp the given Player entity and return the cleaned up one.
     *
     * Cleaning up means things like trimming names for example
     */
    private Player cleanUpPlayer(Player dirtyPlayer) {
        Player.PlayerBuilder playerBuilder = Player.builder();

        // clean up id
        playerBuilder.id(dirtyPlayer.getId());

        // clean up forename
        if (dirtyPlayer.getForeName() != null) {
            playerBuilder.foreName(dirtyPlayer.getForeName().trim());
        }

        // clean up surname
        if (dirtyPlayer.getSurName() != null) {
            playerBuilder.surName(dirtyPlayer.getSurName().trim());
        }

        return playerBuilder.build();
    }
}