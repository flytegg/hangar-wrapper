package gg.flyte.hangarWrapper.api

import de.jensklingenberg.ktorfit.http.Body
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import gg.flyte.hangarWrapper.api.model.SearchPagination
import gg.flyte.hangarWrapper.api.model.Sort
import gg.flyte.hangarWrapper.implementation.Pagination
import gg.flyte.hangarWrapper.implementation.hangarProject.Project
import gg.flyte.hangarWrapper.implementation.hangarProjects.Projects
import java.time.OffsetDateTime

interface HangarAPI {

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
    ): Projects

    @GET("projects/{slug}")
    suspend fun getProject(
        @Path slug: String,
    ): Project

    @GET("projects/{slug}/watchers")
    suspend fun getProjectWatchers(
        @Path slug: String,
        @Query limit: Int,
        @Query offset: Int,
    ): String

    @GET("projects/{slug}/stats")
    suspend fun getProjectStats(
        @Path slug: String,
        @Query fromDate: OffsetDateTime,
        @Query toDate: OffsetDateTime,
    ): String

    @GET("projects/{slug}/stargazers")
    suspend fun getProjectStargazers(
        @Path slug: String,
        @Query limit: Int,
        @Query offset: Int,
    ): String

    @GET("projects/{slug}/members")
    suspend fun getProjectMembers(
        @Path slug: String,
        @Query limit: Int,
        @Query offset: Int,
    ): String

}