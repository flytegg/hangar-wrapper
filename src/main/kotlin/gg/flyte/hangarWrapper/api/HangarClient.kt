package gg.flyte.hangarWrapper.api

import de.jensklingenberg.ktorfit.Ktorfit
import gg.flyte.hangarWrapper.api.model.*
import gg.flyte.hangarWrapper.implementation.Pagination
import gg.flyte.hangarWrapper.implementation.Platform
import gg.flyte.hangarWrapper.implementation.hangarProject.Project
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.gson.*

object HangarClient {

    private lateinit var ktorfit: Ktorfit
    private lateinit var hangarApi: HangarAPI
    private lateinit var client: HttpClient

    var userAgent = "flytegg/hangar-api"

    fun getKtorfit(): Ktorfit {
        if (!::ktorfit.isInitialized) {
            throw IllegalStateException("Ktorfit has not been initialized! Please use HangarClient.Build() first!")
        }

        return ktorfit
    }

    suspend fun test() = client.get("https://hangar.papermc.io/api/v1/projects?limit=5&offset=0&sort=downloads")

    suspend fun getProjects(
        searchPagination: SearchPagination,
        prioritizeExactMatch: Boolean = true,
        order: Order = Order.DESC,
        sort: Sort? = null,
        category: Category? = null,
        platform: Platform? = null,
        query: String? = null,
        license: String? = null,
        version: String? = null,
        tag: Tag? = null,

        ) = hangarApi.getProjects(
        searchPagination.limit,
        searchPagination.offset,
        prioritizeExactMatch,
        putOrNull(sort, "${order.value}${sort.toString().lowercase()}"),
        category?.toString()?.lowercase(),
        platform?.toString(),
        query,
        license,
        version,
        tag?.toString()
    )

    private fun putOrNull(value: Any?, text: String) = if (value == null) text else null

    class Builder(init: Builder.() -> Unit) {
        private var userAgent = "flytegg/hangar-api"

        var logging = true
        var loggingLevel = LogLevel.ALL
        var logger = Logger.DEFAULT
        var customLogger: Logger? = null

        fun build() {
            client = HttpClient(CIO) {
                install(ContentNegotiation) {
                    gson {
                        setPrettyPrinting()
                    }
                }
                if (logging) {
                    install(Logging) {
                        this.logger = logger
                        this.level = loggingLevel

                        if (customLogger != null) {
                            this.logger = customLogger!!
                        }
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

            hangarApi = ktorfit.create()
        }

        init {
            apply(init)
        }
    }
}