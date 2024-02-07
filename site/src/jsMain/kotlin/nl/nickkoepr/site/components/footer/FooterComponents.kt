package nl.nickkoepr.site.components.footer

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

const val SPACE = "\u00A0"

/**
 * [Column] for footer items.
 *
 * @param content the content that has to be displayed into the column.
 */
@Composable
fun FooterColumn(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        content()
    }
}

val CopyrightTextStyle by ComponentStyle {
    base {
        Modifier.fontSize(15.px)
    }
}

/**
 * Copyright text that can be used in the footer.
 *
 * @param text the text that will be displayed in the copyright message.
 */
@Composable
fun CopyrightText(text: String, modifier: Modifier = Modifier) {
    P(attrs = CopyrightTextStyle.toModifier().then(modifier).toAttrs()) {
        Text(text)
    }
}

val SmallFooterTextStyle by ComponentStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .fontSize(15.px)
            .margin(0.px)
            .fontStyle(FontStyle.Italic)
            .flexWrap(FlexWrap.Wrap)
            .justifyContent(JustifyContent.Center)
    }
}

/**
 * Composable function that renders the given [content] in a [P] element.
 *
 * @param content the content that has to be placed in the P element.
 */
@Composable
fun SmallFooterText(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    P(attrs = SmallFooterTextStyle.toModifier().then(modifier).toAttrs()) {
        content()
    }
}