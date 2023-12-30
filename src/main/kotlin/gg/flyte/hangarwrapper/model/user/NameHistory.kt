package gg.flyte.hangarwrapper.model.user

/**
 * Data class representing information about a file, including its name, size in bytes, and SHA-256 hash.
 *
 * @property name the name of the file.
 * @property sizeBytes the size of the file in bytes.
 * @property sha256Hash the SHA-256 hash of the file.
 */
data class NameHistory(
    val oldName: String,
    val newName: String,
    val date: String
)