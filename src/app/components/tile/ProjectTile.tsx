import { useState } from "react";
import StyledButton from "../button/StyledButton";
import "./ProjectTile.css";

export default function ProjectTile() {
  const [showMore, setShowMore] = useState(false);

  return (
    <>
      <div className="project-tile">
        <div className="project-row">
          <img
            style={{
              height: "110px",
            }}
            src="tictactoe.svg"
            alt=""
          />
          <div className="project-info">
            <h3 className="font-bold project-title">TicTacToe</h3>
            <p className="font-regular project-subtitle">
              Play TicTacToe on Discord!
            </p>
          </div>

          <div className="project-button">
            <StyledButton
              onClick={() => setShowMore(!showMore)}
              buttonLabel={`${showMore ? "Less" : "More"} info`}
            />
          </div>
        </div>

        <div
          className={`project-details-container ${showMore ? "expanded" : ""}`}
        >
          <div className="project-details">
            <div className="project-tech-stack">
              <img src="python.svg" />
            </div>
            <p className="font-regular project-description">
              With TicTacToe, Discord users can play a simple game of tic tac
              toe with each other.
            </p>
            <div className="project-detail-buttons">
              <StyledButton buttonLabel="Invite the bot" fontSize={18} />
              <StyledButton buttonLabel="Website" fontSize={18} />
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
