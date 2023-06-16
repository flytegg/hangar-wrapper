package gg.flyte.hangarWrapper.implementation.hangarStargazers

import gg.flyte.hangarWrapper.implementation.Pagination
import gg.flyte.hangarWrapper.implementation.hangarUser.User

data class Stargazers(
    val pagination: Pagination,
    val result: ArrayList<User>
)