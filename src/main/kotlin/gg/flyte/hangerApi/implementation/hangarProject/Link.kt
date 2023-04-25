package gg.flyte.hangerApi.implementation.hangarProject

/**
 * Data class representing a link, which contains an ID, type, title, and list of sub-links.
 * @property id the ID of the link.
 * @property type the type of the link.
 * @property title the title of the link.
 * @property links a list of sub-links.
 */
data class Link(
    val id: Int,
    val type: String,
    val title: String,
    val links: List<SubLink>
)