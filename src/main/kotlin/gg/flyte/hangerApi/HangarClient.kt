package gg.flyte.hangerApi

import com.google.gson.Gson
import gg.flyte.hangerApi.implementation.hangarProject.Project
import gg.flyte.hangerApi.implementation.hangarProjects.Projects
import gg.flyte.hangerApi.implementation.hangarUser.User
import gg.flyte.hangerApi.util.getJsonData
import gg.flyte.hangerApi.implementation.Platform
import gg.flyte.hangerApi.implementation.hangarVersion.Version
import gg.flyte.hangerApi.implementation.hangarVersion.Versions

object HangarClient {

    private const val BASE_DOMAIN = "https://hangar.papermc.io/api/v1/"
    private val gson = Gson();

    fun getProjects(orderWithRelevance: Boolean, limit: Int, offset: Int): Projects {
        if (limit > 25) {
            throw IllegalArgumentException("Limit can't be higher than 25! (Limit: $limit)")
        }

        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects?orderWithRelevance=$orderWithRelevance&limit=$limit&offset=$offset"), Projects::class.java)
    }

    fun getProject(author: String, slug: String): Project {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects/$author/$slug"), Project::class.java)
    }

    fun getUser(user: String): User {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "users/${user}"), User::class.java)
    }

    fun getVersions(author: String, slug: String): Versions {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects/$author/$slug/versions"), Versions::class.java)
    }

    fun getVersion(author: String, slug: String, version: String): Version {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects/$author/$slug/versions/$version"), Version::class.java)
    }

    fun getTotalProjectCount(): Int {
        return getProjects(true, 1, 0).pagination.count
    }

    fun getDownloadURL(author: String, slug: String, version: String, platform: Platform): String {
        return BASE_DOMAIN + "projects/$author/$slug/versions/$version/$platform/download"
    }
}