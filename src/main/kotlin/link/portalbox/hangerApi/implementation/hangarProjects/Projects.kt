package link.portalbox.hangerApi.implementation.hangarProjects

import link.portalbox.hangerApi.implementation.Pagination
import link.portalbox.hangerApi.implementation.hangarProject.Project

data class Projects(
    val pagination: Pagination,
    val result: List<Project>
)
