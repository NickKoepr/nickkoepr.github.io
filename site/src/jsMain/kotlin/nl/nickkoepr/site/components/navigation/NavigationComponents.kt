package nl.nickkoepr.site.components.navigation

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSFloat
import com.varabyte.kobweb.compose.css.ListStyleType
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import nl.nickkoepr.site.components.link.DefaultLink
import nl.nickkoepr.site.domain.navigation.NavigationItem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Ul

val NavigationItemsStyle by ComponentStyle {
    base {
        Modifier.listStyle(ListStyleType.None).padding(0.px)
    }
}

/**
 * Composable that creates a navigation bar with the [Nav] HTML element from the given [navigationItems].
 *
 * @param navigationItems [NavigationItem] class with all the navigation locations.
 */
@Composable
fun NavigationBar(navigationItems: List<NavigationItem>, modifier: Modifier = Modifier) {
    Nav(attrs = modifier.toAttrs()) {
        Ul(attrs = NavigationItemsStyle.toModifier().toAttrs()) {
            navigationItems.forEach { item ->
                Li(attrs = Modifier.float(CSSFloat.Left).toAttrs()) {
                    NavigationLink(navigationName = item.navigationName, pageLocation = item.pageLocation)
                }
            }
        }
    }
}

val NavigationItemStyle by ComponentStyle {
    base {
        Modifier.padding { right(10.px) }.fontSize(18.px)
    }
}

/**
 * Composable that creates a navigation link based on the [navigationName] and the [pageLocation].
 *
 * @param [navigationName] the name of the link navigation.
 * @param [pageLocation] the location on the page. When clicked, the link will navigate to the HTML component with the given pageLocation id (with #).
 */
@Composable
fun NavigationLink(navigationName: String, pageLocation: String, modifier: Modifier = Modifier) {
    Box(NavigationItemStyle.toModifier().then(modifier)) {
        DefaultLink(linkText = navigationName, link = "#$pageLocation")
    }
}