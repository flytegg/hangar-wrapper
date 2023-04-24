package link.portalbox.hangerApi.implementation.hangarVersion

import link.portalbox.hangerApi.implementation.Pagination

data class Versions(
    val pagination: Pagination,
    val result: List<Version>
)