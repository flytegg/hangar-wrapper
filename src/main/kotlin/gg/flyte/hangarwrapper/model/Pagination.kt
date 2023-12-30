package gg.flyte.hangarwrapper.model

/**
 * A data class representing the pagination information for a list of items.
 *
 * @property limit The maximum number of items that can be requested in a single query.
 * @property offset The offset from the beginning of the list to start retrieving items from.
 * @property count The total number of items available in the list.
 */
data class Pagination(
    val limit: Int,
    val offset: Int,
    val count: Int,
)
