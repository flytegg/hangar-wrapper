package gg.flyte.hangarwrapper.model.project

data class CompactRole(
    val title: String,
    val color: String,
    val rank: Int,
    val category: String,
) {
    fun findColor() = Color.entries.firstOrNull { it.hex == color }
}
