package link.portalbox.hangerApi.implementation.hangarProject

data class Project (
    val createdAt: String,
    val name: String,
    val namespace: Namespace,
    val stats: Stats,
    val category: String,
    val lastUpdated: String,
    val visibility: String,
    val avatarUrl: String,
    val description: String,
    val userActions: UserActions,
    val settings: Settings
) {
    fun getDownloadURL(): String {
        return ""
    }
}