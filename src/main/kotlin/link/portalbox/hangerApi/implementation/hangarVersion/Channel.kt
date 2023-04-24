package link.portalbox.hangerApi.implementation.hangarVersion

data class Channel(
    val createdAt: String,
    val name: String,
    val color: String,
    val flags: List<String>
)