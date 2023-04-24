package gg.flyte.hangerApi.implementation.hangarProject

import gg.flyte.hangerApi.HangarClient
import gg.flyte.hangerApi.implementation.Platform
import gg.flyte.hangerApi.implementation.hangarVersion.Version

data class Project (
    val createdAt: String,
    val name: String,
    val namespace: Namespace,
    val stats: Stats,
    val category: String,
    val lastUpdated: String,
    val visibility: String,
    val avatarUrl: String,
    val description: String,
    val userActions: UserActions,
    val settings: Settings
) {
    fun getLatestDownloadURL(): String {
        val version = HangarClient.getVersions(namespace.owner, namespace.slug).result.first()
        return HangarClient.getDownloadURL(namespace.owner, namespace.slug, version.name, Platform.valueOf(version.downloads.keys.first()))
    }

    fun getVersions(): List<Version> {
        return HangarClient.getVersions(namespace.owner, namespace.slug).result
    }
}