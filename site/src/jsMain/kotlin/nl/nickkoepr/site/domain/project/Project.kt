package nl.nickkoepr.site.domain.project

import androidx.compose.runtime.Composable

/**
 * Object representing a project.
 *
 * @param projectImageLocation location of the project image (can be null).
 * @param projectTitle the title of the project.
 * @param projectDescription the description of the project.
 * @param projectLinks place to define project links from [ProjectLinkScope].
 */
data class Project(
    val projectImageLocation: String? = null,
    val projectTitle: String,
    val projectDescription: String,
    val projectLinks: @Composable ProjectLinkScope.() -> Unit
)

/**
 * Representing a link scope that can be used to access project link specific link composable functions.
 */
object ProjectLinkScope
