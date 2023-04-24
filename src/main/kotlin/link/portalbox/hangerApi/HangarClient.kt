package link.portalbox.hangerApi

import com.google.gson.Gson
import link.portalbox.hangerApi.implementation.hangarProject.Project
import link.portalbox.hangerApi.implementation.hangarProjects.Projects
import link.portalbox.hangerApi.implementation.hangarUser.User
import link.portalbox.hangerApi.util.getJsonData

object HangarClient {

    private const val BASE_DOMAIN = "https://hangar.papermc.io/api/v1/"

    fun getProjects(orderWithRelevance: Boolean, limit: Int, offset: Int): Projects {
        if (limit > 25) {
            throw IllegalArgumentException("Limit can't be higher than 25! (Limit: $limit)")
        }

        return Gson().fromJson(getJsonData(BASE_DOMAIN + "projects?orderWithRelevance=$orderWithRelevance&limit=$limit&offset=$offset"), Projects::class.java)
    }

    fun getProject(author: String, slug: String): Project {
        return Gson().fromJson(getJsonData(BASE_DOMAIN + "projects/$author/$slug"), Project::class.java)
    }

    fun getUser(user: String): User {
        return Gson().fromJson(getJsonData(BASE_DOMAIN + "users/${user}"), User::class.java)
    }

    fun totalProjectCount(): Int {
        return HangarClient.getProjects(true, 1, 0).pagination.count
    }
}