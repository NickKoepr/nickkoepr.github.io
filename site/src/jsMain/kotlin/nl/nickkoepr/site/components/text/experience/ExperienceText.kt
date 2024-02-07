package nl.nickkoepr.site.components.text.experience

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text

/**
 * Composable that creates a [H3] title that can be used as the experience title.
 *
 * @param title title of the [H3] element.
 */
@Composable
fun ExperienceTitle(title: String, modifier: Modifier = Modifier) {
    H3(attrs = modifier.fontSize(22.px).fontWeight(FontWeight.Normal).textAlign(TextAlign.Center).toAttrs()) {
        Text(title)
    }
}