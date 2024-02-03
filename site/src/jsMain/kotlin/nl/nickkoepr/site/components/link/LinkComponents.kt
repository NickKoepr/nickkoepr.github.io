package nl.nickkoepr.site.components.link

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.ariaHidden
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.target
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import nl.nickkoepr.site.styling.linkColor
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
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
 * @param openNewWindow if true, open the page in a new browser window.
 */
@Composable
fun DefaultLink(linkText: String, link: String, openNewWindow: Boolean = false, modifier: Modifier = Modifier) {
    Box(modifier = DefaultLinkStyle.toModifier().then(modifier)) {
        A(attrs = DefaultLinkStyle.toAttrs {
            if (openNewWindow) target(ATarget.Blank)
        }, href = link) {
            Row {
                LinkBracket("(")
                Text(linkText)
                LinkBracket(")")
            }
        }
    }
}

@Composable
fun LinkBracket(bracket: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.ariaHidden(true)) {
        Text(bracket)
    }
}