package gg.flyte.hangarwrapper.model.project

/**
 * Data class representing donation information, including whether donations are enabled and the subject of the donations.
 *
 * @property enable whether donations are enabled.
 * @property subject the subject of the donations.
 */
data class Donation(
    val enable: Boolean,
    val subject: String
)
