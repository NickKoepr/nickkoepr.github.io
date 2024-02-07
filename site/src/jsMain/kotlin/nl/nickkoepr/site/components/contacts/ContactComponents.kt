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

@Composable
fun ContactColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}

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

@Composable
fun ContactLink(linkWithIcon: LinkWithIcon, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LinkWithIconItem(linkWithIcon = linkWithIcon, modifier = modifier.padding { bottom(9.px) })
    }
}