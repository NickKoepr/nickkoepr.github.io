package nl.nickkoepr.site.components.projects.card

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import nl.nickkoepr.site.components.link.DefaultLink
import nl.nickkoepr.site.domain.project.Project
import nl.nickkoepr.site.domain.project.ProjectLinkScope
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Composable function that represents a list of [ProjectCard] composables based off the given [Project] list.
 *
 * @param projects list with [Project] objects.
 */
@Composable
fun ProjectList(projects: List<Project>, modifier: Modifier = Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        projects.forEachIndexed { index, project ->
            ProjectCard(project, modifier = Modifier.padding { if (index < projects.size - 1) bottom(30.px) })
        }
    }
}

/**
 * Composable function that shows a (optional) [ProjectCardImage], a [ProjectCardTitle], a [ProjectCardDescription]
 * and the given [Project.projectLinks] in a [Column].
 *
 * @param project [Project] object that will be rendered inside this composable function.
 */
@Composable
fun ProjectCard(project: Project, modifier: Modifier = Modifier) {
    project.run {
        Column(modifier = modifier.id(projectTitle), horizontalAlignment = Alignment.CenterHorizontally) {
            projectImageLocation?.let { ProjectCardImage(it, modifier = Modifier.padding { top(20.px) }) }
            ProjectCardTitle(projectTitle, modifier = Modifier.padding {
                top(20.px)
            })
            ProjectCardDescription(projectDescription)
            ProjectLinkScope.projectLinks()
        }
    }
}

val ProjectCardTitleStyle by ComponentStyle {
    base {
        Modifier
            .fontWeight(FontWeight.Normal)
            .margin(0.px)
            .textAlign(TextAlign.Center)
            .fontSize(25.px)
    }
}

/**
 * Composable function that displays a [H3] title.
 *
 * @param title title that will be placed in the h3.
 */
@Composable
fun ProjectCardTitle(title: String, modifier: Modifier = Modifier) {
    H3(attrs = ProjectCardTitleStyle.toModifier().then(modifier).toAttrs()) {
        Text(title)
    }
}

/**
 * Composable function that displays an [Image] of the given [imageLocation].
 *
 * @param imageLocation the location of the image.
 */
@Composable
fun ProjectCardImage(imageLocation: String, modifier: Modifier = Modifier) {
    Div(attrs = modifier.toAttrs()) {
        Image(
            src = imageLocation,
            width = 140,
            height = 140
        )
    }
}

val ProjectCardDescriptionStyle by ComponentStyle {
    base {
        Modifier.textAlign(TextAlign.Center)
    }
}

/**
 * Composable function that displays a description in a [P] element.
 *
 * @param description description that will be displayed in the P element.
 */
@Composable
fun ProjectCardDescription(description: String, modifier: Modifier = Modifier) {
    P(attrs = ProjectCardDescriptionStyle.toModifier().then(modifier).toAttrs()) {
        Text(description)
    }
}

/**
 * Composable function that displays a default link for the project card.
 *
 * @param link the link url.
 * @param linkText display text for the link.
 */
@Composable
fun DefaultProjectCardLink(link: String, linkText: String, modifier: Modifier = Modifier) {
    DefaultLink(
        link = link,
        linkText = linkText,
        openNewWindow = true,
        modifier = modifier
    )
}

val BigProjectCardLinkStyle by ComponentStyle {
    base {
        Modifier.fontSize(18.px).padding { bottom(11.px) }
    }
}

/**
 * Composable function that renders a big link of [DefaultProjectCardLink].
 * This is an extension function of [ProjectLinkScope].
 *
 * @param link the link url.
 * @param linkText display text for the link.
 */
@Composable
fun ProjectLinkScope.BigProjectCardLink(link: String, linkText: String, modifier: Modifier = Modifier) {
    DefaultProjectCardLink(link, linkText, modifier = BigProjectCardLinkStyle.toModifier().then(modifier))
}


val SmallProjectCardLinkStyle by ComponentStyle {
    base {
        Modifier.fontSize(15.px).padding { bottom(13.px) }
    }
}

/**
 * Composable function that renders a small link of [DefaultProjectCardLink].
 * This is an extension function of [ProjectLinkScope].
 *
 * @param link the link url.
 * @param linkText display text for the link.
 */
@Composable
fun ProjectLinkScope.SmallProjectCardLink(link: String, linkText: String, modifier: Modifier = Modifier) {
    DefaultProjectCardLink(link, linkText, modifier = SmallProjectCardLinkStyle.toModifier().then(modifier))
}