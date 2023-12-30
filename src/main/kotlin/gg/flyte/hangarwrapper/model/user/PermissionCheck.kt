package gg.flyte.hangarwrapper.model.user

data class PermissionCheck(
    val type: String,
    val permissionBinString: String,
    val permissions: List<String>
)
