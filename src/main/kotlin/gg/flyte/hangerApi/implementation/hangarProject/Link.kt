package gg.flyte.hangerApi.implementation.hangarProject

data class Link (
    val id: Int,
    val type: String,
    val title: String,
    val links: List<SubLink>
)