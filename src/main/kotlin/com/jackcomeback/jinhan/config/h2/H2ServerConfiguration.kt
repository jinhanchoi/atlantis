package com.jackcomeback.jinhan.config.h2

import org.h2.tools.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.sql.SQLException

@Configuration
class H2ServerConfiguration {

    @Throws(SQLException::class)
    @Bean
    fun h2TcpServer() : Server {
        return Server.createTcpServer().start()
    }
}