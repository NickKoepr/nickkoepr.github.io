package nl.nickkoepr.site.components.text

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text

val PageTitleStyle by ComponentStyle {
    base {
        Modifier.fontWeight(FontWeight.Bold).fontSize(20.px)
    }
}

/**
 * Composable that creates a [H1] element with a [HeaderUnderline].
 *
 * @param title Page title that will be displayed in the h1.
 */
@Composable
fun PageTitle(title: String, modifier: Modifier = Modifier) {
    Column(modifier = PageTitleStyle.toModifier().then(modifier), horizontalAlignment = Alignment.CenterHorizontally) {
        H1(attrs = Modifier.margin(0.px).toAttrs()) {
            Text(title)
        }
        HeaderUnderline()
    }
}

val SectionTitleStyle by ComponentStyle {
    base {
        Modifier.fontWeight(FontWeight.Normal).fontSize(30.px).margin(0.px)
    }
}

/**
 * Composable that creates a [H2] element with a [HeaderUnderline].
 *
 * @param title Section title that will be displayed in the h2.
 */
@Composable
fun SectionTitle(title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        H2(attrs = SectionTitleStyle.toAttrs()) {
            Text(title)
        }
        HeaderUnderline()
    }
}


/**
 * Underline for headings. Hidden for assistive technologies.
 */
@Composable
fun HeaderUnderline(modifier: Modifier = Modifier) {
    Box(modifier = modifier.ariaHidden(true)) {
        Div {
            Text("----")
        }
    }
}
