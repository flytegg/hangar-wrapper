package gg.flyte.hangarWrapper.api

import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.gson.*

object HangarClient {

    private lateinit var ktorfit: Ktorfit
    private lateinit var client: HttpClient

    var userAgent = "flytegg/hangar-api"

    fun getKtorfit(): Ktorfit {
        if (!::ktorfit.isInitialized) {
            throw IllegalStateException("Ktorfit has not been initialized! Please use HangarClient.Build() first!")
        }

        return ktorfit
    }


    class Builder(init: Builder.() -> Unit) {
        private var userAgent = "flytegg/hangar-api"

        private var logging = true
        private var loggingLevel = LogLevel.ALL

        fun build() {
            client = HttpClient(CIO) {
                install(ContentNegotiation) {
                    gson {
                        setPrettyPrinting()
                    }
                }
                if (logging) {
                    install(Logging) {
                        level = loggingLevel
                        logger = Logger.DEFAULT
                    }
                }
                install(UserAgent) {
                    agent = HangarClient.userAgent
                }
            }

            ktorfit = Ktorfit.Builder()
                .baseUrl("https://hangar.papermc.io/api/v1/")
                .httpClient(client)
                .build()
        }

        init {
            apply(init)
        }
    }
}