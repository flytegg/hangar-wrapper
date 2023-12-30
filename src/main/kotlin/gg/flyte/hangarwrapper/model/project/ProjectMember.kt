package gg.flyte.hangarwrapper.model.project

data class ProjectMember(
    val user: String,
    val roles: List<CompactRole>
)
