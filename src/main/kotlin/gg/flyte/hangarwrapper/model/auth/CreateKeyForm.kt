package gg.flyte.hangarwrapper.model.auth

data class CreateKeyForm(
    val name: String,
    val permissions: List<NamedPermission>,
)
