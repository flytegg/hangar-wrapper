import gg.flyte.hangarWrapper.api.HangarClient
import gg.flyte.hangarWrapper.api.model.SearchPagination
import gg.flyte.hangarWrapper.api.model.Sort
import gg.flyte.hangarWrapper.implementation.Pagination
import io.ktor.client.plugins.logging.*

suspend fun main() {
    HangarClient.Builder {
        logger = Logger.SIMPLE
        loggingLevel = LogLevel.INFO
    }.build()

    HangarClient.getProject("ViaVersion").let(::println)


}