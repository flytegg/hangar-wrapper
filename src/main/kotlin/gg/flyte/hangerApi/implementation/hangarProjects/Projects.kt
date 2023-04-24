package gg.flyte.hangerApi.implementation.hangarProjects

import gg.flyte.hangerApi.implementation.Pagination
import gg.flyte.hangerApi.implementation.hangarProject.Project

data class Projects(
    val pagination: Pagination,
    val result: List<Project>
)
