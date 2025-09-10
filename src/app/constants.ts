import type { Experience } from "./components/tile/ExperienceTile";
import type { Project } from "./components/tile/ProjectTile";

export const experiences: Experience[] = [
  {
    experienceTitle: "Gradle",
    imageLocation: "gradle.svg"
  },
  {
    experienceTitle: "Android Studio",
    imageLocation: "androidstudio.svg"
  },
  {
    experienceTitle: "Figma",
    imageLocation: "figma.svg"
  },
  {
    experienceTitle: "Git",
    imageLocation: "git.svg"
  },
  {
    experienceTitle: "IntelliJ IDEA",
    imageLocation: "intellijidea.svg"
  },
  {
    experienceTitle: "JavaScript",
    imageLocation: "javascript.svg"
  },
  {
    experienceTitle: "Jetpack Compose",
    imageLocation: "jetpackcompose.svg"
  },
  {
    experienceTitle: "Kotlin",
    imageLocation: "kotlin.svg"
  },
  {
    experienceTitle: "Postgres",
    imageLocation: "postgresql.svg"
  },
  {
    experienceTitle: "Python",
    imageLocation: "python.svg"
  },
  {
    experienceTitle: "React",
    imageLocation: "react.svg"
  },
  {
    experienceTitle: "TypeScript",
    imageLocation: "typescript.svg"
  }
]

export const projects: Project[] = [
  {
      title: "TicTacToe",
      subtitle: "Play TicTacToe on Discord!",
      description: "With TicTacToe, Discord users can play a simple game of tic tac toe with each other.",
      imageLocation: "tictactoe.svg",
      buttonBackgroundColor: "ttt-button-color",
      buttonBorderColor: "ttt-button-border-color",
      buttonTextColor: "ttt-button-text-color",
      tools: [
        {
          toolName: "Python",
          imageLocation: "python.svg"
        },
      ],
      buttons: [
        {
            label: "Invite the bot",
            urlToOpen: "https://discord.com/discovery/applications/914110118998732811"
        },
        {
            label: "Website",
            urlToOpen: "https://tictactoe.nickkoepr.nl/"
        },
        {
            label: "Repository",
            urlToOpen: "https://github.com/NickKoepr/TicTacToe"
        }
      ]
  },

  {
      title: "Bored",
      subtitle: "App to combat boredom.",
      description: "An Android app that gives suggestions to combat boredom.",
      imageLocation: "bored.png",
      buttonBackgroundColor: "bored-button-color",
      buttonBorderColor: "bored-button-border-color",
      buttonTextColor: "bored-button-text-color",
      tools: [
        {
          toolName: "Android Studio",
          imageLocation: "androidstudio.svg"
        },
        {
          toolName: "Kotlin",
          imageLocation: "kotlin.svg"
        },
        {
          toolName: "Jetpack Compose",
          imageLocation: "jetpackcompose.svg"
        },
      ],
      buttons: [
        {
            label: "Repository",
            urlToOpen: "https://github.com/NickKoepr/Bored"
        }
      ]
  }
]
