package gg.flyte.hangerApi.implementation.hangarVersion

data class DownloadInfo(
    val fileInfo: FileInfo,
    val externalUrl: String,
    val downloadUrl: String?
)