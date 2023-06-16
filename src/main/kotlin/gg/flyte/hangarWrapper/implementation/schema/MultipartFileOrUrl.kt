package gg.flyte.hangarWrapper.implementation.schema

data class MultipartFileOrUrl(
    val platforms: List<String>, // change to enum
    val externalUrl: String,
    val url: Boolean,
)
