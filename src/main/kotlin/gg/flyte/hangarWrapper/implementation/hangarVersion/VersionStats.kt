package gg.flyte.hangarWrapper.implementation.hangarVersion

/**
 * A data class representing the download statistics for a version of a plugin.
 *
 * @property totalDownloads The total number of downloads for the version.
 * @property platformDownloads A [Map] of platform names to the number of downloads for that platform.
 */
data class VersionStats(
    val totalDownloads: Int,
    val platformDownloads: Map<String, Int>
)