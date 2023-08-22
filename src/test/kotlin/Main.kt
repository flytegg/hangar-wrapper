import gg.flyte.hangarWrapper.HangarClient

fun main() {
    HangarClient.getProject("ViaVersion", "ViaRewind").getVersions().forEach {
        println(it.pluginDependencies)
    }
}

