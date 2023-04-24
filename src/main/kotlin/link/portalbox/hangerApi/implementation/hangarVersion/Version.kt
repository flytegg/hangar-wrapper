package link.portalbox.hangerApi.implementation.hangarVersion

import link.portalbox.hangerApi.implementation.Platform

data class Version(
    val createdAt: String,
    val name: String,
    val visibility: String,
    val description: String,
    val stats: VersionStats,
    val author: String,
    val reviewState: String,
    val channel: Channel,
    val pinnedStatus: String,
    val downloads: Map<String, DownloadInfo>,
    val platformDependencies: Map<Platform, List<String>>,
    val platformDependenciesFormatted: Map<Platform, String>
)
