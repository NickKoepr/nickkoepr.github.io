package nl.nickkoepr.site.components.text.introduction

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

/**
 * Column for designing an introduction [Column].
 * @param content the content of the column.
 */
@Composable
fun IntroductionColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier.id("hello"), horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}

val HelloMessageStyle by ComponentStyle {
    base {
        Modifier.fontSize(18.px).padding { bottom(10.px) }
    }
}

/**
 * Composable function that creates a hello message based on the given [text].
 * It renders a [H2] element with the given text.
 *
 * @param text hello message text.
 */
@Composable
fun HelloMessage(text: String, modifier: Modifier = Modifier) {
    Box(HelloMessageStyle.toModifier().then(modifier)) {
        H2(attrs = Modifier.margin(0.px).fontWeight(FontWeight.Normal).toAttrs()) {
            Text(text)
        }
    }
}

val IntroductionMessageStyle by ComponentStyle {
    base {
        Modifier.fontSize(16.px).textAlign(TextAlign.Center)
    }
}

/**
 * Composable function that creates an introduction text based on the given [introText].
 * This function renders a [P] element with the given content.
 *
 * @param [introText] the introduction text that has to be rendered.
 */
@Composable
fun IntroductionText(introText: String, modifier: Modifier = Modifier) {
    Box(modifier = IntroductionMessageStyle.toModifier().then(modifier)) {
        P(attrs = Modifier.margin(0.px).toAttrs()) {
            Text(introText)
        }
    }
}