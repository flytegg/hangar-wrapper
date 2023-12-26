package gg.flyte.hangarWrapper.api.model

import gg.flyte.hangarWrapper.implementation.Pagination

data class PaginatedResult<T>(
    val pagination: Pagination,
    val result: List<T>
)
