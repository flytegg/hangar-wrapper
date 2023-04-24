package gg.flyte.hangerApi.implementation.hangarVersion

data class FileInfo(
    val name: String,
    val sizeBytes: Int,
    val sha256Hash: String,
)