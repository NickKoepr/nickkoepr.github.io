package nl.nickkoepr.site.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import nl.nickkoepr.site.components.text.PageTitle
import nl.nickkoepr.site.components.text.introduction.HelloMessage
import nl.nickkoepr.site.components.text.introduction.IntroductionColumn
import nl.nickkoepr.site.components.text.introduction.IntroductionText
import nl.nickkoepr.site.styling.RootStyle
import nl.nickkoepr.site.styling.backgroundColor
import nl.nickkoepr.site.styling.fontColor
import nl.nickkoepr.site.styling.fontFamily
import org.jetbrains.compose.web.css.px

val HomePageStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxSize()
            .backgroundColor(backgroundColor.value())
            .color(fontColor.value())
            .fontFamily(fontFamily.value())
            .padding(15.px)
    }
}

/**
 * Entry point for the HomePage. All separate page composable functions are called in here.
 */
@Page
@Composable
fun HomePage(modifier: Modifier = RootStyle.toModifier()) {
    Column(modifier = modifier.then(HomePageStyle.toModifier()), verticalArrangement = Arrangement.Top) {
        PageTitle("NickKoepr")
        IntroductionColumn {
            HelloMessage("Hello!")
            IntroductionText(
                "I am Nick, 19 year old software developer from the Netherlands"
            )
            IntroductionText(
                "Studying at the University of applied sciences Utrecht. "
            )
        }
    }
}
