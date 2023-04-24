package link.portalbox.hangerApi.implementation.hangarProject

import link.portalbox.hangerApi.HangarClient
import link.portalbox.hangerApi.implementation.hangarUser.User

data class Namespace (
    val owner: String,
    val slug: String
) {
    fun getOwnerAsUser(): User {
        return HangarClient.getUser(owner)
    }
}