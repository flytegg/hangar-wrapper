import gg.flyte.hangarWrapper.HangarClient

fun main() {
    HangarClient.getAllStarGazers("flyte", "pluginportal").forEach {
        println(it.name)
    }
}

