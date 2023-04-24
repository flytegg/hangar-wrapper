package link.portalbox.hangerApi.implementation.hangarUser

data class User(
    val createdAt: String,
    val name: String,
    val tagline: String,
    val roles: List<Int>,
    val projectCount: Int,
    val locked: Boolean,
    val nameHistory: List<NameHistory>,
    val avatarUrl: String,
    val isOrganization: Boolean,
)