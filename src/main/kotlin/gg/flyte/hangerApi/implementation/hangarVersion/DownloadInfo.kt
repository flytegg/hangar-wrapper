package gg.flyte.hangerApi.implementation.hangarVersion

/**
 * Data class representing download information, including file information, external URL, and download URL (if available).
 * @property fileInfo information about the downloaded file, including its name, size in bytes, and SHA-256 hash.
 * @property externalUrl the external URL to download the file.
 * @property downloadUrl the download URL to download the file, or null if not available.
 */
data class DownloadInfo(
    val fileInfo: FileInfo,
    val externalUrl: String,
    val downloadUrl: String?
)