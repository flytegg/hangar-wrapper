import gg.flyte.hangarWrapper.api.HangarClient
import gg.flyte.hangarWrapper.api.model.RequestPagination
import gg.flyte.hangarWrapper.api.model.project.ProjectSortingStrategy
import gg.flyte.hangarWrapper.api.model.user.UserSortingStrategy
import io.ktor.client.plugins.logging.*

suspend fun main() {
    HangarClient.Builder {
        logger = Logger.SIMPLE // Sanitizeheader github.com/ktorio/ktor-documentation/blob/2.3.7/codeSnippets/snippets/client-logging/src/main/kotlin/com/example/Application.kt
        loggingLevel = LogLevel.INFO
    }.build()


    println(HangarClient.getUserPinned(
        RequestPagination(10, 0),
        "Dawson",
    ))


}