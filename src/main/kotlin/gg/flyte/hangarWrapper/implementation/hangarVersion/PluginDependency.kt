package gg.flyte.hangarWrapper.implementation.hangarVersion

import gg.flyte.hangarWrapper.implementation.Platform
import gg.flyte.hangarWrapper.implementation.hangarProject.Namespace

data class PluginDependency(
    val name: String,
    val required: Boolean,
    val namespace: Namespace,
    val externalUrl: String?,
    val platform: Platform
)