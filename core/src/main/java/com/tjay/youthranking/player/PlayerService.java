package com.tjay.youthranking.player;

import com.tjay.youthranking.general.YouthRatingException;
import com.tjay.youthranking.player.internal.PlayerRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

import static com.tjay.youthranking.general.YouthRatingErrorCodes.FORENAME_AND_SURNAME_COMBINATION_NOT_UNIQUE;
import static com.tjay.youthranking.general.YouthRatingErrorCodes.FORENAME_OR_SURNAME_MUST_NOT_BE_EMPTY;

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
                FORENAME_OR_SURNAME_MUST_NOT_BE_EMPTY);
        }

        // Combination for ForeName and SurName must not exists already
        Optional<Player> existingForeNameSurNamePlayer = playerRepository.findPlayerByForeNameAndSurName(player.getForeName().trim(), player.getSurName().trim());
        if (existingForeNameSurNamePlayer.isPresent()) {
            throw new YouthRatingException("There is already a player with the same forename and surname: " + existingForeNameSurNamePlayer.get(),
                FORENAME_AND_SURNAME_COMBINATION_NOT_UNIQUE);
        }
    }

    /**
     * Method will cleanUp the given Player entity and return the cleaned up one.
     * <p>
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