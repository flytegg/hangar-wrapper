package gg.flyte.hangarwrapper.model.version

import gg.flyte.hangarwrapper.model.Platform
import gg.flyte.hangarwrapper.model.project.Namespace

data class PluginDependency(
    val name: String,
    val required: Boolean,
    val namespace: Namespace,
    val externalUrl: String?,
    val platform: Platform
)