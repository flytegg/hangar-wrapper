package gg.flyte.hangarWrapper.implementation.hangarProject

import gg.flyte.hangarWrapper.HangarClient
import gg.flyte.hangarWrapper.implementation.hangarUser.User

/**
 * Data class representing a namespace for a project or organization, including the owner's name and the slug.
 * @property owner the name of the user or organization that owns the namespace
 * @property slug the unique identifier for the namespace
 */
data class Namespace(
    val owner: String,
    val slug: String
) {
    /**
     * Returns the User object associated with this namespace's owner.
     * @return a User object representing the owner of this namespace
     */
    fun getOwnerAsUser(): User {
        return HangarClient.getUser(owner)
    }
}