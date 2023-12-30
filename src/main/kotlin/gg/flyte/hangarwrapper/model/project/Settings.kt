package gg.flyte.hangarwrapper.model.project

/**
 * Data class representing the settings of a project, including its links, tags, license, keywords, sponsors and donation information.
 *
 * @property links a list of [Link] objects that contain information about the project's links.
 * @property tags a list of tags associated with the project.
 * @property license the [License] object containing information about the project's license.
 * @property keywords a list of keywords associated with the project.
 * @property sponsors a string containing the name of the sponsor(s) of the project.
 * @property donation a [Donation] object containing information about the project's donation settings.
 */
data class Settings(
    val links: List<Link>,
    val tags: List<String>,
    val license: License,
    val keywords: List<String>,
    val sponsors: String,
    val donation: Donation
)
