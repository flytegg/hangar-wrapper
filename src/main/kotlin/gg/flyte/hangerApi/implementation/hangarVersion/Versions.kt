package gg.flyte.hangerApi.implementation.hangarVersion

import gg.flyte.hangerApi.implementation.Pagination

data class Versions(
    val pagination: Pagination,
    val result: List<Version>
)