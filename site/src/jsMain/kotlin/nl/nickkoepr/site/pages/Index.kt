package nl.nickkoepr.site.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import nl.nickkoepr.site.components.experience.ExperienceCardList
import nl.nickkoepr.site.components.experience.ExperienceColumn
import nl.nickkoepr.site.components.link.LinkWithIconList
import nl.nickkoepr.site.components.navigation.NavigationBar
import nl.nickkoepr.site.components.text.PageTitle
import nl.nickkoepr.site.components.text.experience.ExperienceTitle
import nl.nickkoepr.site.components.text.introduction.HelloMessage
import nl.nickkoepr.site.components.text.introduction.IntroductionColumn
import nl.nickkoepr.site.components.text.introduction.IntroductionText
import nl.nickkoepr.site.domain.experience.Experience
import nl.nickkoepr.site.domain.link.LinkWithIcon
import nl.nickkoepr.site.domain.navigation.NavigationItem
import nl.nickkoepr.site.styling.RootStyle
import nl.nickkoepr.site.styling.backgroundColor
import nl.nickkoepr.site.styling.fontColor
import nl.nickkoepr.site.styling.fontFamily
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Header
import org.jetbrains.compose.web.dom.Main

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
    Column(
        modifier = modifier.then(HomePageStyle.toModifier()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header {
            PageTitle("NickKoepr")

            NavigationBar(
                navigationItems = listOf(
                    NavigationItem(navigationName = "hello", pageLocation = "hello"),
                    NavigationItem(navigationName = "project", pageLocation = "project"),
                    NavigationItem(navigationName = "contact", pageLocation = "contact")
                )
            )
        }

        Main {
            IntroductionColumn(modifier = Modifier.padding { top(30.px) }) {
                HelloMessage("Hello!")
                IntroductionText(
                    "I am Nick, 19 year old software developer from the Netherlands"
                )
                IntroductionText(
                    "Studying at the University of applied sciences Utrecht. "
                )

                LinkWithIconList(
                    listOf(
                        LinkWithIcon(
                            iconLocation = "/icons/linkedin.svg",
                            iconAlt = "Linkedin",
                            linkText = "Nick Kuiper",
                            link = "https://www.linkedin.com/in/nick-kuiper-010b75266/"
                        ),
                        LinkWithIcon(
                            iconLocation = "/icons/github.svg",
                            iconAlt = "GitHub",
                            linkText = "NickKoepr",
                            link = "https://github.com/nickkoepr/"
                        )
                    )
                )
            }

            ExperienceColumn(modifier = Modifier.padding { top(20.px) }) {
                ExperienceTitle("Experience with")

                ExperienceCardList(
                    listOf(
                        Experience(name = "Android\nStudio", iconLocation = "/icons/experience/androidstudio.svg"),
                        Experience(name = "Python", iconLocation = "/icons/experience/python.svg"),
                        Experience(name = "Figma", iconLocation = "/icons/experience/figma.svg"),
                        Experience(name = "Intellij\nIDEA", iconLocation = "/icons/experience/intellijidea.svg"),
                        Experience(name = "Kotlin", iconLocation = "/icons/experience/kotlin.svg"),
                        Experience(name = "Git", iconLocation = "/icons/experience/git.svg"),
                    ),
                    modifier = Modifier.margin { left(10.px) }
                )
            }
        }
    }
}