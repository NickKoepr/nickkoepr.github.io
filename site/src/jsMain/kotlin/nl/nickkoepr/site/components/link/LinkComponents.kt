package nl.nickkoepr.site.components.link

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.ariaLabel
import com.varabyte.kobweb.compose.css.role
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toAttrs
import nl.nickkoepr.site.components.list.HorizontalLi
import nl.nickkoepr.site.components.list.HorizontalUl
import nl.nickkoepr.site.domain.link.LinkWithIcon
import nl.nickkoepr.site.styling.linkColor
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text

val DefaultLinkStyle by ComponentStyle {
    base {
        Modifier
            .color(linkColor.value())
            .textDecorationLine(TextDecorationLine.None)
    }
}

/**
 * Default link composable that will navigate to the given [link] when clicked.
 *
 * @param linkText link text displayed to the user.
 * @param link link that has to open when clicked.
 * @param linkAltText (optional) alt text for link that can be used by assistive technologies.
 * @param openNewWindow if true, open the page in a new browser window.
 */
@Composable
fun DefaultLink(
    linkText: String,
    link: String,
    openNewWindow: Boolean = false,
    linkAltText: String? = null,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.then(modifier)) {
        A(attrs = DefaultLinkStyle.toAttrs {
            if (openNewWindow) target(ATarget.Blank)

            linkAltText?.let {label ->
                ariaLabel(label)
            }

            role("link")
        }, href = link) {
            Row {
                LinkBracket("(")
                Text(linkText)
                LinkBracket(")")
            }
        }
    }
}

/**
 * Simple bracket that can be displayed at the start and the end of a link text.
 *
 * @param bracket the bracket string.
 */
@Composable
fun LinkBracket(bracket: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.ariaHidden(true)) {
        Text(bracket)
    }
}

/**
 * A [DefaultLink] with an icon as prefix.
 *
 * @param linkWithIcon [LinkWithIcon] object that represents a link.
 */
@Composable
fun LinkWithIconItem(linkWithIcon: LinkWithIcon, modifier: Modifier = Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        Image(
            src = linkWithIcon.iconLocation,
            width = 20,
            height = 20,
            modifier = Modifier.margin { right(8.px) }.ariaHidden(true)
        )
        DefaultLink(
            linkText = linkWithIcon.linkText,
            link = linkWithIcon.link,
            linkAltText = "${linkWithIcon.iconAlt} ${linkWithIcon.linkText}",
            openNewWindow = true
        )
    }
}

/**
 * A [HorizontalUl] list filled with [LinkWithIconItem]
 *
 * @param linkWithIcons list of [LinkWithIcon] objects that will be displayed inside the list.
 */
@Composable
fun LinkWithIconList(linkWithIcons: List<LinkWithIcon>, modifier: Modifier = Modifier) {
    HorizontalUl(modifier = modifier) {
        linkWithIcons.forEach { item ->
            HorizontalLi {
                LinkWithIconItem(item)
            }
        }
    }
}
