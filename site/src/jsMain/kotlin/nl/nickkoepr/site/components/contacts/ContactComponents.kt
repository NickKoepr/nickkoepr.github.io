package nl.nickkoepr.site.components.contacts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import nl.nickkoepr.site.components.link.LinkWithIconItem
import nl.nickkoepr.site.components.list.VerticalLi
import nl.nickkoepr.site.components.list.VerticalUl
import nl.nickkoepr.site.domain.link.LinkWithIcon
import org.jetbrains.compose.web.css.px

/**
 * [Column] for contact items.
 *
 * @param content the content that has to be displayed into the column.
 */
@Composable
fun ContactColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}

/**
 * Create a [VerticalUl] list with the given [linkWithIcons]. These will be rendered with the [ContactLink] composable.
 *
 * @param linkWithIcons list with [LinkWithIcon] objects.
 */
@Composable
fun ContactLinkList(linkWithIcons: List<LinkWithIcon>, modifier: Modifier = Modifier) {
    VerticalUl(modifier = modifier) {
        linkWithIcons.forEach { linkWithIcon ->
            VerticalLi {
                ContactLink(linkWithIcon = linkWithIcon)
            }
        }
    }
}

/**
 * [LinkWithIcon] for a given [LinkWithIcon].
 *
 * @param linkWithIcon [LinkWithIcon] object.
 */
@Composable
fun ContactLink(linkWithIcon: LinkWithIcon, modifier: Modifier = Modifier) {
    LinkWithIconItem(linkWithIcon = linkWithIcon, modifier = modifier.padding { bottom(9.px) })
}