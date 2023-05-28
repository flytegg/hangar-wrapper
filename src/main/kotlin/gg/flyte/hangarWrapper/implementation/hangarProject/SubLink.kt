package gg.flyte.hangarWrapper.implementation.hangarProject

/**
 * Data class representing a sublink for a Link, including its id, name, and URL.
 * @property id the id of the sublink.
 * @property name the name of the sublink.
 * @property url the URL of the sublink.
 */
data class SubLink(
    val id: Int,
    val name: String,
    val url: String
)
