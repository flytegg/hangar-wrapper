package gg.flyte.hangarwrapper.model.auth

data class ApiSession(
    val token: String,
    val expiresIn: Long,
)
