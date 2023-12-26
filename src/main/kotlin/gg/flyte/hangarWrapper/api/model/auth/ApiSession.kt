package gg.flyte.hangarWrapper.api.model.auth

data class ApiSession(
    val token: String,
    val expiresIn: Long,
)
