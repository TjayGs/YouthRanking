package com.tjay.youthRanking;

import io.micronaut.context.annotation.Value;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import org.h2.tools.Server;

import java.sql.SQLException;

import static io.micronaut.data.model.query.builder.sql.Dialect.H2;

public class Application {

    public static void main(String[] args) throws SQLException {
        // Cando What happens if postgres is the dialect ?
        Server.createWebServer().start();
        Micronaut.run(Application.class, args);
    }
}
