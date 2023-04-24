package gg.flyte.hangerApi.implementation.hangarProject

import gg.flyte.hangerApi.HangarClient
import gg.flyte.hangerApi.implementation.hangarUser.User

data class Namespace (
    val owner: String,
    val slug: String
) {
    fun getOwnerAsUser(): User {
        return HangarClient.getUser(owner)
    }
}