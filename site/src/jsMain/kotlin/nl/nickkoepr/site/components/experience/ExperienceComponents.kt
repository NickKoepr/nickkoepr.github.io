package nl.nickkoepr.site.components.experience

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import nl.nickkoepr.site.components.list.HorizontalLi
import nl.nickkoepr.site.components.list.HorizontalUl
import nl.nickkoepr.site.domain.experience.Experience
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Experience card that combines the [ExperienceIcon] and the [ExperienceLabel].
 */
@Composable
fun ExperienceCard(name: String, iconLocation: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExperienceIcon(iconLocation = iconLocation)
        ExperienceLabel(title = name)
    }
}

val ExperienceTitleStyle by ComponentStyle {
    base {
        Modifier
            .margin { top(5.px) }
            .textAlign(TextAlign.Center)
            .whiteSpace(WhiteSpace.PreLine)
    }
}

/**
 * Composable function that creates a title for the [ExperienceCard].
 *
 * @param title title that has to be displayed.
 */
@Composable
fun ExperienceLabel(title: String, modifier: Modifier = Modifier) {
    P(attrs = ExperienceTitleStyle.toModifier().then(modifier).toAttrs()) {
        Text(title)
    }
}

/**
 * Composable function that creates a given icon for an [ExperienceCard].
 *
 * @param iconLocation the location of the icon.
 */
@Composable
fun ExperienceIcon(iconLocation: String, modifier: Modifier = Modifier) {
    Div(attrs = modifier.toAttrs()) {
        Image(
            src = iconLocation,
            width = 40,
            height = 40,
            modifier = Modifier.ariaHidden(true)
        )
    }
}

/**
 * [HorizontalUl] list with all the given [Experience] objects.
 *
 * @param experiences list with all the [Experience] objects.
 */
@Composable
fun ExperienceCardList(experiences: List<Experience>, modifier: Modifier = Modifier) {
    HorizontalUl(modifier = modifier) {
        experiences.forEach { experience ->
            HorizontalLi {
                ExperienceCard(experience.name, experience.iconLocation, modifier = Modifier.margin { right(10.px) })
            }
        }
    }
}

/**
 * Column representing the Experience section content.
 *
 * @param content the content that has to be displayed.
 */
@Composable
fun ExperienceColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}
