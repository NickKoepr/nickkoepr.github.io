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
import nl.nickkoepr.site.components.projects.ProjectsColumn
import nl.nickkoepr.site.components.projects.card.BigProjectCardLink
import nl.nickkoepr.site.components.projects.card.ProjectList
import nl.nickkoepr.site.components.projects.card.SmallProjectCardLink
import nl.nickkoepr.site.components.text.PageTitle
import nl.nickkoepr.site.components.text.SectionTitle
import nl.nickkoepr.site.components.text.experience.ExperienceTitle
import nl.nickkoepr.site.components.text.introduction.HelloMessage
import nl.nickkoepr.site.components.text.introduction.IntroductionColumn
import nl.nickkoepr.site.components.text.introduction.IntroductionText
import nl.nickkoepr.site.domain.experience.Experience
import nl.nickkoepr.site.domain.link.LinkWithIcon
import nl.nickkoepr.site.domain.navigation.NavigationItem
import nl.nickkoepr.site.domain.project.Project
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
            PageTitle("Nick Kuiper")

            NavigationBar(
                navigationItems = listOf(
                    NavigationItem(navigationName = "hello", pageLocation = "hello"),
                    NavigationItem(navigationName = "projects", pageLocation = "projects"),
                    NavigationItem(navigationName = "contact", pageLocation = "contact")
                )
            )
        }

        Main {
            IntroductionColumn(modifier = Modifier.padding { top(30.px) }) {
                HelloMessage("Hello!")
                IntroductionText(
                    "I am Nick," +
                            " ${js("Math.floor(Math.abs(new Date() - new Date(\"12/25/2004\")) / (1000 * 60 * 60 * 24 * 365))")} " +
                            "year old software developer from the Netherlands."
                )
                IntroductionText(
                    "Studying at the University of applied sciences Utrecht."
                )
                IntroductionText(
                    "Mostly interesting in Android and backend development."
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

            ProjectsColumn(
                modifier = Modifier.padding {
                    top(30.px)
                }
            ) {
                SectionTitle("Projects", modifier = Modifier.padding { bottom(20.px) })
                ProjectList(listOf(
                    Project(
                        projectImageLocation = "/images/projects/bored_logo.webp",
                        projectTitle = "Bored",
                        projectDescription = "Android app that combats your boredom",
                        projectLinks = {
                            BigProjectCardLink(
                                linkText = "find on GitHub",
                                link = "https://github.com/NickKoepr/Bored"
                            )
                        }
                    )
                    ,Project(
                        projectImageLocation = "/images/projects/tictactoe_logo.jpg",
                        projectTitle = "TicTacToe",
                        projectDescription = "Play Tic Tac Toe with your friends on Discord with the TicTacToe Discord bot!",
                        projectLinks = {
                            BigProjectCardLink(
                                linkText = "invite the bot",
                                link = "https://top.gg/bot/914110118998732811"
                            )
                            BigProjectCardLink(
                                linkText = "source code on GitHub",
                                link = "https://github.com/NickKoepr/TicTacToe-V2"
                            )
                            SmallProjectCardLink(
                                linkText = "privacy policy",
                                link = "https://docs.google.com/document/d/e/2PACX-1vR7ZV1pUrErWNUH0sY_8KbZN2s3meKM71wKvtL5cwFQ0V6-utx2PW0GvLUoNCccqni52Z4fxgoGWWh0/pub"
                            )
                            SmallProjectCardLink(
                                linkText = "terms of service",
                                link = "https://docs.google.com/document/d/e/2PACX-1vQQ0nMg0msUX2CCxmj47ZDYRU4SMfCf0R7hoF61N_3vfKAmJyUw7uQUe90Jfz8e613xogqsvrUKYp91/pub"
                            )
                        }
                    )
                ))
            }
        }
    }
}