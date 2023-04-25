package gg.flyte.hangerApi.implementation.hangarProject

/**
 * Represents a user's actions on a project.
 * @property starred whether the user has starred the project.
 * @property watching whether the user is watching the project.
 * @property flagged whether the user has flagged the project.
 */
data class UserActions(
    val starred: Boolean,
    val watching: Boolean,
    val flagged: Boolean
)
