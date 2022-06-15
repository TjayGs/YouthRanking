package com.tjay.youthRanking.player


import spock.lang.Specification

class PlayerControllerTest extends Specification {

    def repository = Mock(PlayerRepository)

    def controller = new PlayerController(repository)

    def 'get player for a correct id'() {
        given:
           def player = Mock(Player)

        when:
           def result = controller.findById(0)

        then:
           1 * repository.findById(0) >> Optional.of(player)

        and:
           result == player
    }

    def 'throw exception if wrong id is given'() {
        when:
           controller.findById(1)

        then:
           1 * repository.findById(1) >> Optional.empty()

        and:
           thrown(IllegalArgumentException)
    }
}
