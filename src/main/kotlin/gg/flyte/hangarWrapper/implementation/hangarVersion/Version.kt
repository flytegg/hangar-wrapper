package gg.flyte.hangarWrapper.implementation.hangarVersion

import gg.flyte.hangarWrapper.implementation.Platform

/**
 * Represents a version of a plugin on the Hangar platform.
 *
 * @property createdAt The date and time at which this version was created.
 * @property name The name of this version.
 * @property visibility The visibility of this version (public or private).
 * @property description The description of this version.
 * @property stats The download statistics for this version.
 * @property author The username of the author of this version.
 * @property reviewState The review state of this version.
 * @property channel The channel for this version.
 * @property pinnedStatus The pinned status of this version.
 * @property downloads The download information for this version.
 * @property platformDependencies The platform dependencies for this version, organized by [Platform].
 * @property platformDependenciesFormatted The formatted platform dependencies for this version, organized by [Platform].
 */
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
) {
    /**
     * Returns the download URL for this version of the plugin for a given [Platform].
     *
     * If the download information for the specified [Platform] is not found, an empty string will be returned.
     *
     * @param platform The [Platform] for which to retrieve the download URL.
     * @return The download URL for the specified [Platform], or an empty string if the download information is not found.
     */
    fun getDownloadURL(platform: Platform): String {
        val downloadInfo = downloads[platform.name]

        if (downloadInfo != null) {
            return downloadInfo.downloadUrl ?: downloadInfo.externalUrl
        }

        return ""
    }
}
