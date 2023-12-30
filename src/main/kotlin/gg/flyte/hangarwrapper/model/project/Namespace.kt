package gg.flyte.hangarwrapper.model.project

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
    suspend fun getOwnerAsUser() = gg.flyte.hangarwrapper.HangarClient.getUser(owner)

}