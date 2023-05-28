package gg.flyte.hangarWrapper.implementation.hangarUser

/**
 * Data class representing a Hangar user.
 * @property createdAt the creation date of the user.
 * @property name the username of the user.
 * @property tagline the tagline of the user.
 * @property roles the list of roles the user has.
 * @property projectCount the number of projects the user has.
 * @property locked whether the user is locked.
 * @property nameHistory the list of names the user has had.
 * @property avatarUrl the URL of the user's avatar.
 * @property isOrganization whether the user is an organization.
 */
data class User(
    val createdAt: String,
    val name: String,
    val tagline: String,
    val roles: List<Int>,
    val projectCount: Int,
    val locked: Boolean,
    val nameHistory: List<NameHistory>,
    val avatarUrl: String,
    val isOrganization: Boolean,
)