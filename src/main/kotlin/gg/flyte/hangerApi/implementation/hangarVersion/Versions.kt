package gg.flyte.hangerApi.implementation.hangarVersion

import gg.flyte.hangerApi.implementation.Pagination

/**
 * A data class representing a list of versions for a plugin.
 *
 * @property pagination The pagination information for the list of versions.
 * @property result The list of [Version] objects.
 */
data class Versions(
    val pagination: Pagination,
    val result: List<Version>
)