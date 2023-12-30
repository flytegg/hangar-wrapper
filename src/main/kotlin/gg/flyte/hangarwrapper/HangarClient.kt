package gg.flyte.hangarwrapper

import de.jensklingenberg.ktorfit.Ktorfit
import gg.flyte.hangarwrapper.model.*
import gg.flyte.hangarwrapper.model.auth.*
import gg.flyte.hangarwrapper.model.project.*
import gg.flyte.hangarwrapper.model.user.*
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.serialization.gson.*
import java.time.OffsetDateTime

object HangarClient {

    private lateinit var ktorfit: Ktorfit
    private lateinit var hangarApi: HangarAPI
    lateinit var client: HttpClient

    private var apiKey: String? = null
    private var apiSession: ApiSession? = null

    var userAgent = "flytegg/hangar-api"

    fun getKtorfit(): Ktorfit {
        if (!HangarClient::ktorfit.isInitialized) {
            throw IllegalStateException("Ktorfit has not been initialized! Please use HangarClient.Build() first!")
        }

        return ktorfit
    }

    /*

    PROJECTS

     */

    suspend fun getProjects(
        requestPagination: RequestPagination,
        prioritizeExactMatch: Boolean = true,
        sortDirection: SortDirection = SortDirection.DESC,
        projectSortingStrategy: ProjectSortingStrategy? = null,
        category: Category? = null,
        platform: Platform? = null,
        owner: String? = null,
        query: String? = null,
        license: String? = null,
        version: String? = null,
        tag: Tag? = null,
    ) = hangarApi.getProjects(
        requestPagination.limit,
        requestPagination.offset,
        prioritizeExactMatch,
        projectSortingStrategy.toQueryParam(sortDirection),
        category?.toString()?.lowercase(),
        platform?.toString(),
        owner,
        query,
        license,
        version,
        tag?.toString()
    )

    suspend fun getProject(slug: String) = hangarApi.getProject(slug)
    suspend fun getProjectWatchers(
        slug: String,
        pagination: RequestPagination
    ) = hangarApi.getProjectWatchers(slug, pagination.limit, pagination.offset)

    suspend fun getProjectStats(
        slug: String,
        fromDate: OffsetDateTime,
        toDate: OffsetDateTime
    ) = hangarApi.getProjectStats(slug, fromDate, toDate)

    suspend fun getProjectStargazers(
        slug: String,
        pagination: RequestPagination
    ) = hangarApi.getProjectStargazers(slug, pagination.limit, pagination.offset)

    suspend fun getProjectMembers(
        slug: String,
        pagination: RequestPagination
    ) = hangarApi.getProjectMembers(slug, pagination.limit, pagination.offset)


    /*

    Versions

     */

    suspend fun getVersions(
        slug: String,
        pagination: RequestPagination,
        platform: Platform? = null,
        channel: String? = null,
        platformVersion: String? = null,
    ) = hangarApi.getVersions(
        slug,
        pagination.limit,
        pagination.offset,
        channel,
        platform?.toString(),
        platformVersion,
    )

    suspend fun getVersion(
        slug: String,
        version: String,
    ) = hangarApi.getVersion(slug, version)

    suspend fun getVersionDownload(
        slug: String,
        version: String,
        platform: Platform,
    ) = hangarApi.getVersionDownload(slug, version, platform.toString())

    suspend fun getVersionDownloadUrl(
        slug: String,
        version: String,
        platform: Platform,
    ) = "https://hangar.papermc.io/api/v1/projects/$slug/versions/$version/$platform/download"

    suspend fun getVersionStats(
        slug: String,
        version: String,
        toDate: OffsetDateTime,
        fromDate: OffsetDateTime,
    ) = hangarApi.getVersionStats(slug, version, toDate, fromDate)

    suspend fun getLatestRelease(
        slug: String,
    ) = hangarApi.getLatestRelease(slug)

    suspend fun getLatestVersion(
        slug: String,
        channel: String,
    ) = hangarApi.getLatestVersion(slug, channel)

    /*

    Users

     */

    suspend fun getUsers(
        pagination: RequestPagination,
        query: String,
        sortDirection: gg.flyte.hangarwrapper.model.SortDirection = gg.flyte.hangarwrapper.model.SortDirection.DESC,
        userSortingStrategy: UserSortingStrategy? = null,
    ) = hangarApi.getUsers(
        pagination.limit,
        pagination.offset,
        query,
        userSortingStrategy
            ?.toString()
            ?.lowercase()
            ?.replace("_", "")
            .let { if (it == null) null else "${sortDirection.value}$it" },
    )

    suspend fun getUser(username: String) = hangarApi.getUser(username)
    suspend fun getUserWatching(
        pagination: RequestPagination,
        username: String,
        sortDirection: gg.flyte.hangarwrapper.model.SortDirection = gg.flyte.hangarwrapper.model.SortDirection.DESC,
        projectSortingStrategy: ProjectSortingStrategy? = null,
    ) = hangarApi.getUserWatching(
        pagination.limit,
        pagination.offset,
        username,
        projectSortingStrategy.toQueryParam(sortDirection)
    )

    suspend fun getUserStarred(
        requestPagination: RequestPagination,
        username: String,
        sortDirection: gg.flyte.hangarwrapper.model.SortDirection = gg.flyte.hangarwrapper.model.SortDirection.DESC,
        projectSortingStrategy: ProjectSortingStrategy? = null,
    ) = hangarApi.getUserStarred(
        requestPagination.limit,
        requestPagination.offset,
        username,
        projectSortingStrategy.toQueryParam(sortDirection)
    )

    suspend fun getUserPinned(
        requestPagination: RequestPagination,
        username: String,
        sortDirection: gg.flyte.hangarwrapper.model.SortDirection = gg.flyte.hangarwrapper.model.SortDirection.DESC,
        projectSortingStrategy: ProjectSortingStrategy? = null,
    ) = hangarApi.getUserPinned(
        requestPagination.limit,
        requestPagination.offset,
        username,
        projectSortingStrategy.toQueryParam(sortDirection)
    )

    suspend fun getStaff(
        requestPagination: RequestPagination,
        query: String,
        sortDirection: gg.flyte.hangarwrapper.model.SortDirection = gg.flyte.hangarwrapper.model.SortDirection.DESC,
        userSortingStrategy: UserSortingStrategy? = null,
    ) = hangarApi.getStaff(
        requestPagination.limit,
        requestPagination.offset,
        query,
        userSortingStrategy.toQueryParam(sortDirection)
    )

    suspend fun getAuthors(
        requestPagination: RequestPagination,
        query: String,
        sortDirection: gg.flyte.hangarwrapper.model.SortDirection = gg.flyte.hangarwrapper.model.SortDirection.DESC,
        userSortingStrategy: UserSortingStrategy? = null,
    ) = hangarApi.getAuthors(
        requestPagination.limit,
        requestPagination.offset,
        query,
        userSortingStrategy.toQueryParam(sortDirection)
    )

    /*

    API Keys

     */

    suspend fun authenticate(apiKey: String) = hangarApi
        .authenticate(apiKey)
        .also { session -> gg.flyte.hangarwrapper.HangarClient.apiSession = session }

    suspend fun getApiKeys() = hangarApi.getKeys()
    suspend fun createApiKey(
        createKeyForm: CreateKeyForm
    ) = hangarApi.createKey(createKeyForm)
    suspend fun deleteApiKey(name: String) = hangarApi.deleteKey(name)

    /*

    Permissions

     */

    suspend fun getPermissions(
        slug: String? = null,
        organization: String? = null,
    ) = hangarApi.getPermissions(
        slug,
        organization
    )

    suspend fun hasAnyPermission(
        permissions: List<String>,
        slug: String? = null,
        organization: String? = null,
    ) = hangarApi.hasAnyPermission(
        permissions,
        slug,
        organization
    )

    suspend fun hasAllPermissions(
        permissions: List<String>,
        slug: String? = null,
        organization: String? = null,
    ) = hangarApi.hasAllPermissions(
        permissions,
        slug,
        organization
    )

    private fun ProjectSortingStrategy?.toQueryParam(sortDirection: gg.flyte.hangarwrapper.model.SortDirection) = this
        ?.toString()
        ?.lowercase()
        .let { if (it == null) null else "${sortDirection.value}$it" }

    private fun UserSortingStrategy?.toQueryParam(sortDirection: gg.flyte.hangarwrapper.model.SortDirection) = this
        ?.paramName
        .let { if (it == null) null else "${sortDirection.value}$it" }

    class Builder(init: gg.flyte.hangarwrapper.HangarClient.Builder.() -> Unit) {
        private var userAgent = "flytegg/hangar-api"

        var apiKey: String? = null

        var logging = true
        var loggingLevel = LogLevel.NONE
        var logger = Logger.DEFAULT
        var customLogger: Logger? = null

        fun build() {
            gg.flyte.hangarwrapper.HangarClient.client = HttpClient(CIO) {
                install(ContentNegotiation) {
                    gson {
                        setPrettyPrinting()
                    }
                }
                if (logging) {
                    install(Logging) {
                        this.logger = logger
                        this.level = loggingLevel

                        if (customLogger != null) {
                            this.logger = customLogger!!
                        }
                    }
                }
                install(UserAgent) {
                    agent = userAgent
                }

                defaultRequest {
                    header("Authorization", gg.flyte.hangarwrapper.HangarClient.apiSession?.token)
                }
            }

            gg.flyte.hangarwrapper.HangarClient.ktorfit = Ktorfit.Builder()
                .baseUrl("https://hangar.papermc.io/api/v1/")
                .httpClient(gg.flyte.hangarwrapper.HangarClient.client)
                .build()

            gg.flyte.hangarwrapper.HangarClient.hangarApi = ktorfit.create()
        }

        init {
            apply(init)
        }
    }
}
