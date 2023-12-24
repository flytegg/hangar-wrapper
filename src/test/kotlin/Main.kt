import gg.flyte.hangarWrapper.api.HangarClient
import gg.flyte.hangarWrapper.api.model.SearchPagination
import gg.flyte.hangarWrapper.api.model.Sort
import gg.flyte.hangarWrapper.implementation.Pagination
import io.ktor.client.plugins.logging.*
import java.time.OffsetDateTime
import java.time.temporal.ChronoUnit

suspend fun main() {
    HangarClient.Builder {
        logger = Logger.SIMPLE
        loggingLevel = LogLevel.INFO
    }.build()

    val currentDateTime = OffsetDateTime.now()
    val oneDayAgo = currentDateTime.minus(1, ChronoUnit.DAYS)
    val oneYearAgo = currentDateTime.minus(1, ChronoUnit.YEARS)

    HangarClient.getProjectWatchers("PluginPortal", SearchPagination(25, 0)).let(::println)


}