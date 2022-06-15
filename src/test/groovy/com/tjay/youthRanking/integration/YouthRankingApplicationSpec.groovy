package com.tjay.youthRanking.integration

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class YouthRankingApplicationSpec extends Specification {

    @Inject
    EmbeddedApplication application

    def 'if application is running'() {
        expect:
            application.isRunning()
    }
}
