package gg.flyte.hangerApi.implementation.hangarProjects

import gg.flyte.hangerApi.implementation.Pagination
import gg.flyte.hangerApi.implementation.hangarProject.Project

/**
 * A data class representing a paginated list of projects.
 * @property pagination the pagination information for the list of projects.
 * @property result the list of projects for the current page.
 */
data class Projects(
    val pagination: Pagination,
    val result: List<Project>
)
