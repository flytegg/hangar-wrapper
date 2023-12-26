package gg.flyte.hangarWrapper.api.model.auth

data class CreateKeyForm(
    val name: String,
    val permissions: List<NamedPermission>,
)
