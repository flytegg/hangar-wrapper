package gg.flyte.hangarwrapper

import de.jensklingenberg.ktorfit.http.*
import gg.flyte.hangarwrapper.model.PaginatedResult
import gg.flyte.hangarwrapper.model.project.DayProjectStats
import gg.flyte.hangarwrapper.model.user.User
import gg.flyte.hangarwrapper.model.version.Version
import gg.flyte.hangarwrapper.model.version.VersionStats
import gg.flyte.hangarwrapper.model.auth.ApiSession
import gg.flyte.hangarwrapper.model.auth.CreateKeyForm
import gg.flyte.hangarwrapper.model.project.Project
import gg.flyte.hangarwrapper.model.project.ProjectCompact
import gg.flyte.hangarwrapper.model.project.ProjectMember
import gg.flyte.hangarwrapper.model.user.PermissionCheck
import io.ktor.client.statement.*
import java.time.OffsetDateTime

interface HangarAPI {

    /*

    PROJECTS

     */

    @GET("projects")
    suspend fun getProjects(
        @Query limit: Int,
        @Query offset: Int,
        @Query prioritizeExactMatch: Boolean = true,
        @Query sort: String? = null,
        @Query category: String? = null,
        @Query platform: String? = null,
        @Query owner: String? = null,
        @Query q: String? = null,
        @Query license: String? = null,
        @Query version: String? = null,
        @Query tag: String? = null,
    ): PaginatedResult<Project>

    @GET("projects/{slug}")
    suspend fun getProject(
        @Path slug: String,
    ): PaginatedResult<User>

    @GET("projects/{slug}/watchers")
    suspend fun getProjectWatchers(
        @Path slug: String,
        @Query limit: Int,
        @Query offset: Int,
    ): PaginatedResult<User>

    @GET("projects/{slug}/stats")
    suspend fun getProjectStats(
        @Path slug: String,
        @Query fromDate: OffsetDateTime,
        @Query toDate: OffsetDateTime,
    ): Map<String, DayProjectStats>

    @GET("projects/{slug}/stargazers")
    suspend fun getProjectStargazers(
        @Path slug: String,
        @Query limit: Int,
        @Query offset: Int,
    ): PaginatedResult<User>

    @GET("projects/{slug}/members")
    suspend fun getProjectMembers(
        @Path slug: String,
        @Query limit: Int,
        @Query offset: Int,
    ): PaginatedResult<ProjectMember>

    /*

    Versions

     */

    @GET("projects/{slug}/versions")
    suspend fun getVersions(
        @Path slug: String,
        @Query limit: Int,
        @Query offset: Int,
        @Query channel: String? = null,
        @Query platform: String? = null,
        @Query platformVersion: String? = null,
    ): PaginatedResult<Version>

    @GET("projects/{slug}/versions/{name}")
    suspend fun getVersion(
        @Path slug: String,
        @Path name: String,
    ): Version

    @GET("projects/{slug}/versions/{name}/{platform}/download")
    suspend fun getVersionDownload(
        @Path slug: String,
        @Path name: String,
        @Path platform: String,
    ): HttpResponse

    @GET("projects/{slug}/versions/{name}/stats")
    suspend fun getVersionStats(
        @Path slug: String,
        @Path name: String,
        @Query fromDate: OffsetDateTime,
        @Query toDate: OffsetDateTime,
    ): Map<String, VersionStats>

    @GET("projects/{slug}/latestrelease")
    suspend fun getLatestRelease(
        @Path slug: String,
    ): String

    @GET("projects/{slug}/latest")
    suspend fun getLatestVersion(
        @Path slug: String,
        @Query channel: String,
    ): String



    /*

    Users

     */

    @GET("users")
    suspend fun getUsers(
        @Query limit: Int,
        @Query offset: Int,
        @Query query: String,
        @Query sort: String? = null,
    ): PaginatedResult<User>

    @GET("users/{user}")
    suspend fun getUser(
        @Path user: String,
    ): User

    @GET("users/{user}/watching")
    suspend fun getUserWatching(
        @Query limit: Int,
        @Query offset: Int,
        @Path user: String,
        @Query sort: String? = null,
    ): PaginatedResult<ProjectCompact>

    @GET("users/{user}/starred")
    suspend fun getUserStarred(
        @Query limit: Int,
        @Query offset: Int,
        @Path user: String,
        @Query sort: String? = null,
    ): PaginatedResult<ProjectCompact>

    @GET("users/{user}/pinned")
    suspend fun getUserPinned(
        @Query limit: Int,
        @Query offset: Int,
        @Path user: String,
        @Query sort: String? = null,
    ): PaginatedResult<ProjectCompact>

    @GET("staff")
    suspend fun getStaff(
        @Query limit: Int,
        @Query offset: Int,
        @Query query: String,
        @Query sort: String? = null,
    ): PaginatedResult<User>

    @GET("authors")
    suspend fun getAuthors(
        @Query limit: Int,
        @Query offset: Int,
        @Query query: String,
        @Query sort: String? = null,
    ): PaginatedResult<User>

    /*

    Auth + API Keys

     */

    @POST("authenticate")
    suspend fun authenticate(
        @Query apiKey: String,
    ): ApiSession

    @GET("keys")
    suspend fun getKeys(): String

    @POST("keys")
    suspend fun createKey(
        @Body createKeyForm: CreateKeyForm
    ): String

    @DELETE("keys")
    suspend fun deleteKey(
        @Query name: String
    ): String

    /*

    Permissions

     */

    @GET("permissions")
    suspend fun getPermissions(
        @Query slug: String? = null,
        @Query organization: String? = null,
    ): PaginatedResult<PermissionCheck>

    @GET("permissions/hasAny")
    suspend fun hasAnyPermission(
        @Query permissions: List<String>,
        @Query slug: String? = null,
        @Query organization: String? = null,
    ): String

    @GET("permissions/hasAll")
    suspend fun hasAllPermissions(
        @Query permissions: List<String>,
        @Query slug: String? = null,
        @Query organization: String? = null,
    ): String

}