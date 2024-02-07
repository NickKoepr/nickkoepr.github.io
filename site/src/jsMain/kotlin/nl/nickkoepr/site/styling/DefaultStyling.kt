package nl.nickkoepr.site.styling

import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import org.jetbrains.compose.web.css.CSSColorValue

// Custom CSS properties
val backgroundColor by StyleVariable<CSSColorValue>()
val fontColor by StyleVariable<CSSColorValue>()
val linkColor by StyleVariable<CSSColorValue>()
val fontFamily by StyleVariable<String>()

val BACKGROUND_COLOR = Color.Companion.rgb(37, 37 , 37)
val LINK_COLOR = Color.Companion.rgb(255, 255, 102)
val FONT_COLOR = Colors.White
const val FONT_FAMILY = "Source Code Pro"

val RootStyle by ComponentStyle {
    base {
        Modifier
            .setVariable(backgroundColor, BACKGROUND_COLOR)
            .setVariable(fontColor, FONT_COLOR)
            .setVariable(fontFamily, FONT_FAMILY)
            .setVariable(linkColor, LINK_COLOR)
    }
}