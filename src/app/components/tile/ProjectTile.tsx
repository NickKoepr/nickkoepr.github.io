import { useRef, useState } from "react";
import StyledButton from "../button/StyledButton";
import "./ProjectTile.css";

export type Project = {
  title: string;
  subtitle: string;
  imageLocation: string;
  description: string;
  buttonBackgroundColor: string;
  buttonBorderColor: string;
  buttonTextColor: string;
  tools: { toolName: string; imageLocation: string }[];
  buttons: { label: string; urlToOpen: string }[];
};

interface ProjectTileProps {
  project: Project;
}

export default function ProjectTile({ project }: ProjectTileProps) {
  const reference = useRef<HTMLDivElement | null>(null);
  const [showMore, setShowMore] = useState(false);

  const buttonClick = () => {
    setShowMore(!showMore);
    if (!showMore) {
      // Added a small timeout to let the component expand.
      setTimeout(() => {
        reference.current?.scrollIntoView({ behavior: "smooth" });
      }, 50);
    }
  };

  return (
    <>
      <div className="project-tile" ref={reference}>
        <div className="project-row">
          <img
            style={{
              height: "110px",
              borderRadius: "30px",
            }}
            src={project.imageLocation}
            alt=""
          />
          <div className="project-info">
            <h3 className="font-bold project-title">{project.title}</h3>
            <p className="font-regular project-subtitle">{project.subtitle}</p>
          </div>

          <div className="project-button">
            <StyledButton
              buttonTextColor={project.buttonTextColor}
              backgroundColor={project.buttonBackgroundColor}
              borderColor={project.buttonBorderColor}
              onClick={buttonClick}
              buttonLabel={`${showMore ? "Less" : "More"} info`}
            />
          </div>
        </div>

        <div
          className={`project-details-container ${showMore ? "expanded" : ""}`}
        >
          <div className="project-details" ref={reference}>
            <div className="project-tech-stack">
              {project.tools.map((tool) => (
                <img src={tool.imageLocation} alt={tool.toolName} />
              ))}
            </div>

            <p className="font-regular project-description">
              {project.description}
            </p>
            <div className="project-detail-buttons">
              {project.buttons.map((button) => (
                <StyledButton
                  buttonTextColor={project.buttonTextColor}
                  backgroundColor={project.buttonBackgroundColor}
                  borderColor={project.buttonBorderColor}
                  buttonLabel={button.label}
                  fontSize={18}
                  onClick={() => {
                    window.open(button.urlToOpen, "_blank");
                  }}
                />
              ))}
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
