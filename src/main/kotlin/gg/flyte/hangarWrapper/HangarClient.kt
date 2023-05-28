package gg.flyte.hangarWrapper

import com.google.gson.Gson
import gg.flyte.hangarWrapper.implementation.hangarProject.Project
import gg.flyte.hangarWrapper.implementation.hangarProjects.Projects
import gg.flyte.hangarWrapper.implementation.hangarUser.User
import gg.flyte.hangarWrapper.util.getJsonData
import gg.flyte.hangarWrapper.implementation.Platform
import gg.flyte.hangarWrapper.implementation.hangarVersion.Version
import gg.flyte.hangarWrapper.implementation.hangarVersion.Versions

/**
 * The `HangarClient` object is the main entry point for interacting with the Hangar API.
 * It provides methods for retrieving information about projects, versions, users, and other resources.
 */
object HangarClient {
    private const val BASE_DOMAIN = "https://hangar.papermc.io/api/v1/"
    private val gson = Gson();
    
    /**
     * Retrieves a list of projects.
     *
     * @param orderWithRelevance Set to `true` to order results by relevance.
     * @param limit The maximum number of results to return. Must be lower than 25 (inclusive).
     * @param offset The number of results to skip before beginning to return projects.
     * @throws IllegalArgumentException If `limit` is greater than 25.
     * @return A [Projects] object containing the requested projects.
     */
    fun getProjects(orderWithRelevance: Boolean, limit: Int, offset: Int): Projects {
        if (limit > 25) {
            throw IllegalArgumentException("Limit can't be higher than 25! (Limit: $limit)")
        }

        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects?orderWithRelevance=$orderWithRelevance&limit=$limit&offset=$offset"), Projects::class.java)
    }
    
    /**
     * Retrieves a specific project.
     *
     * @param author The author of the project.
     * @param slug The slug of the project.
     * @return A [Project] object containing the requested project.
     */
    fun getProject(author: String, slug: String): Project {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects/$author/$slug"), Project::class.java)
    }
    
    /**
     * Retrieves information about a specific user.
     *
     * @param user The username of the user to retrieve information about.
     * @return A [User] object containing information about the requested user.
     */
    fun getUser(user: String): User {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "users/${user}"), User::class.java)
    }
    
    /**
     * Retrieves a list of versions for a specific project.
     *
     * @param author The author of the project.
     * @param slug The slug of the project.
     * @return A [Versions] object containing a list of versions for the requested project.
     */
    fun getVersions(author: String, slug: String): Versions {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects/$author/$slug/versions"), Versions::class.java)
    }
    
    /**
     * Retrieves information about a specific version of a project.
     *
     * @param author The author of the project.
     * @param slug The slug of the project.
     * @param version The version of the project to retrieve information about.
     * @return A [Version] object containing information about the requested project version.
     */
    fun getVersion(author: String, slug: String, version: String): Version {
        return gson.fromJson(getJsonData(BASE_DOMAIN + "projects/$author/$slug/versions/$version"), Version::class.java)
    }
    
    /**
     * Retrieves the total number of projects available.
     *
     * @return An integer representing the total number of projects available.
     */
    fun getTotalProjectCount(): Int {
        return getProjects(true, 1, 0).pagination.count
    }
    
    /**
     * Retrieves the download URL for a specific version of a project and platform.
     *
     * @param author The author of the project.
     * @param slug The slug of the project.
     * @param version The version of the project to retrieve the download URL for.
     * @param platform The platform to retrieve the download URL for.
     * @return A string representing the download URL for the specified project version and platform.
     */
    fun getDownloadURL(author: String, slug: String, version: String, platform: Platform): String {
        return BASE_DOMAIN + "projects/$author/$slug/versions/$version/$platform/download"
    }
}