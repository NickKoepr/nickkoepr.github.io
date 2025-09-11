import "./App.css";
import IconButton from "./components/button/IconButton";
import VerticalSpacer from "./components/spacer/VerticalSpacer";
import ExperienceTile from "./components/tile/ExperienceTile";
import ProjectTile from "./components/tile/ProjectTile";
import SegmentTitle from "./components/title/SegmentTitle";
import SiteTitle from "./components/title/SiteTitle";
import SubTitle from "./components/title/SubTitle";
import { experiences, profileButtons, projects } from "./constants";

function App() {
  return (
    <>
      <div className="app">
        <VerticalSpacer height={130} />

        <SiteTitle title="Hi, I am Nick" />
        <SubTitle text="Software developer student" />

        <VerticalSpacer height={30} />

        <div
          style={{
            display: "flex",
            justifyContent: "center",
            gap: "15px",
          }}
        >
          {profileButtons.map((button) => (
            <IconButton iconButton={button} />
          ))}
        </div>

        <VerticalSpacer height={100} />

        <SegmentTitle title="Experience with" />

        <VerticalSpacer height={40} />

        <div className="experiences">
          {experiences.map((experience) => (
            <ExperienceTile experience={experience} />
          ))}
        </div>

        <VerticalSpacer height={80} />

        <SegmentTitle title="Projects" />

        <VerticalSpacer height={40} />

        <div
          style={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            gap: "20px",
          }}
        >
          {projects.map((project) => (
            <ProjectTile project={project} />
          ))}
        </div>
      </div>
    </>
  );
}

export default App;
