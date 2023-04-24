package gg.flyte.hangerApi.implementation.hangarProject

data class Settings(
    val links: List<Link>,
    val tags: List<String>,
    val license: License,
    val keywords: List<String>,
    val sponsors: String,
    val donation: Donation
)
