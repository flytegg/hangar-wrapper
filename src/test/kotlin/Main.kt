import gg.flyte.hangarWrapper.HangarClient

fun main() {
    HangarClient.getProject("ViaRewind").getVersions().forEach {
        println(it.pluginDependencies)
    }
}

