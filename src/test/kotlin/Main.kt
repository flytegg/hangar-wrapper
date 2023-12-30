import gg.flyte.hangarwrapper.HangarClient
import gg.flyte.hangarwrapper.model.RequestPagination
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*

suspend fun main() {
    HangarClient.Builder {
    }.build()

    HangarClient.getLatestVersion("PluginPortal", "Release").let {
        println(it)
    }
}