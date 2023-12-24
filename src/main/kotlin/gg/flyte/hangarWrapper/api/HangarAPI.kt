package gg.flyte.hangarWrapper.api

import de.jensklingenberg.ktorfit.http.GET

interface HangarAPI {

    @GET("projects")
    suspend fun getProjects(): String


}