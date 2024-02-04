package nl.nickkoepr.site.components.list

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSFloat
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.float
import com.varabyte.kobweb.compose.ui.modifiers.listStyle
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul

val HorizontalUlStyle by ComponentStyle {
    base {
        Modifier.flexWrap(FlexWrap.Wrap).listStyle(ListStyleType.None).padding(0.px)
    }
}

/**
 * [Ul] aligned horizontally. This list will be aligned vertical when the screen becomes to small and has no
 *  list style.
 *
 *  @param content the content that has to be displayed inside the list (most likely a [HorizontalLi] item).
 */
@Composable
fun HorizontalUl(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Ul(attrs = HorizontalUlStyle.toModifier().then(modifier).toAttrs()) {
        content()
    }
}

val HorizontalLiStyle by ComponentStyle {
    base {
        Modifier.float(CSSFloat.Left).padding { right(13.px) }
    }
}

/**
 * [Li] aligned horizontally. This list item will be aligned vertical.
 * This item will mostly be used with the [HorizontalUl] composable.
 *
 * @param content the content that has to be displayed inside the list item.
 */
@Composable
fun HorizontalLi(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Li(attrs = HorizontalLiStyle.toModifier().then(modifier).toAttrs()) {
        content()
    }
}
