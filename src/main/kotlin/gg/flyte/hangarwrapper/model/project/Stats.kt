package gg.flyte.hangarwrapper.model.project

/**
 * Represents statistics for a project, including views, downloads, stars, and watchers.
 *
 * @property views the total number of views the project has received.
 * @property downloads the total number of downloads the project has received.
 * @property recentViews the number of views the project has received in the recent period.
 * @property recentDownloads the number of downloads the project has received in the recent period.
 * @property stars the total number of stars the project has received.
 * @property watchers the total number of users who are watching the project.
 */
data class Stats(
    val views: Int,
    val downloads: Int,
    val recentViews: Int,
    val recentDownloads: Int,
    val stars: Int,
    val watchers: Int
)
