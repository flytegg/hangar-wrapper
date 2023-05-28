package gg.flyte.hangarWrapper.implementation.hangarVersion

/**
 * Data class representing information about a project channel, including the creation date, name, color, and flags.
 * @property createdAt the date the channel was created.
 * @property name the name of the channel.
 * @property color the color of the channel.
 * @property flags the list of flags for the channel.
 */
data class Channel(
    val createdAt: String,
    val name: String,
    val color: String,
    val flags: List<String>
)