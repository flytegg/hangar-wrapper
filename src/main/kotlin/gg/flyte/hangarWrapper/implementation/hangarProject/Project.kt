package gg.flyte.hangarWrapper.implementation.hangarProject

import gg.flyte.hangarWrapper.HangarClient
import gg.flyte.hangarWrapper.implementation.Platform
import gg.flyte.hangarWrapper.implementation.hangarVersion.Version

/**
 * Data class representing a project on the Hangar platform, including its metadata and settings.
 * @property createdAt the date the project was created.
 * @property name the name of the project.
 * @property namespace the namespace that owns the project.
 * @property stats statistics about the project's downloads and views.
 * @property category the category the project belongs to.
 * @property lastUpdated the date the project was last updated.
 * @property visibility the visibility of the project (public or private).
 * @property avatarUrl the URL of the project's avatar image.
 * @property description the description of the project.
 * @property userActions the actions that can be taken by the user.
 * @property settings the settings of the project.
 */
data class Project(
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
    /**
     * Returns the download URL for the latest version of this project for the given platform.
     *
     * @return the download URL for the latest version of this project for the given platform.
     */
    fun getLatestDownloadURL(): String {
        val version = HangarClient.getVersions(namespace.owner, namespace.slug).result.first()
        return HangarClient.getDownloadURL(namespace.owner, namespace.slug, version.name, Platform.valueOf(version.downloads.keys.first()))
    }
    
    /**
     * Returns a list of all versions of this project.
     *
     * @return a list of all versions of this project.
     */
    fun getVersions(): List<Version> {
        return HangarClient.getVersions(namespace.owner, namespace.slug).result
    }
}