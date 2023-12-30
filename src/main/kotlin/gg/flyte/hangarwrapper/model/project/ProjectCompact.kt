package gg.flyte.hangarwrapper.model.project

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
 */
data class ProjectCompact(
    val createdAt: String,
    val name: String,
    val namespace: Namespace,
    val stats: Stats,
    val category: String,
    val lastUpdated: String,
    val visibility: String,
    val avatarUrl: String,
)