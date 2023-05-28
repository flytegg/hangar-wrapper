package gg.flyte.hangarWrapper.implementation.hangarProject

/**
 * Data class representing a license for a project, including its name, URL, and type.
 *
 * @property name the name of the license
 * @property url the URL for the license, if available
 * @property type the type of the license (e.g. MIT, GPL, etc.)
 */
data class License(
    val name: String,
    val url: String?,
    val type: String
)
