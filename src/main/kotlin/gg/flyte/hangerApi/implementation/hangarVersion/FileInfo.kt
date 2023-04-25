package gg.flyte.hangerApi.implementation.hangarVersion

/**
 * Data class representing information about a file, including its name, size in bytes, and SHA-256 hash.
 *
 * @property name the name of the file.
 * @property sizeBytes the size of the file in bytes.
 * @property sha256Hash the SHA-256 hash of the file.
 */
data class FileInfo(
    val name: String,
    val sizeBytes: Int,
    val sha256Hash: String,
)