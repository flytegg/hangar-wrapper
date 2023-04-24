package gg.flyte.hangerApi.implementation.hangarVersion

data class VersionStats(
    val totalDownloads: Int,
    val platformDownloads: Map<String, Int>
)