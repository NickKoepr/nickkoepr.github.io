import "./ExperienceTile.css";

export type Experience = {
  imageLocation: string;
  experienceTitle: string;
};

interface TileProps {
  experience: Experience;
}

export default function ExperienceTile({ experience }: TileProps) {
  return (
    <>
      <div className="experience-tile">
        <img
          style={{
            height: "50px",
          }}
          src={experience.imageLocation}
          alt=""
        />

        <p className="font-medium experience-label">
          {experience.experienceTitle}
        </p>
      </div>
    </>
  );
}
