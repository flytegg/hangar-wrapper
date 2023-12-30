package gg.flyte.hangarwrapper.model

data class PaginatedResult<T>(
    val pagination: Pagination,
    val result: List<T>
)
