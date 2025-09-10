import "./IconButton.css";

export type IconButton = {
  iconName: string;
  iconLocation: string;
  iconButtonLink: string;
};

interface IconButtonProps {
  iconButton: IconButton;
}

export default function IconButton({ iconButton }: IconButtonProps) {
  return (
    <>
      <button
        className="icon-button"
        onClick={() => {
          window.open(iconButton.iconButtonLink, "_blank");
        }}
      >
        <img src={iconButton.iconLocation} alt={iconButton.iconName} />
      </button>
    </>
  );
}
