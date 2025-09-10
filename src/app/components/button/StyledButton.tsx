import "./StyledButton.css";

interface StyledButtonProps {
  buttonLabel: string;
  onClick: () => void;
  fontSize?: number;
}

export default function StyledButton({
  buttonLabel,
  onClick,
  fontSize,
}: StyledButtonProps) {
  return (
    <>
      <button
        onClick={onClick}
        style={{
          fontSize: fontSize !== undefined ? `${fontSize}px` : "20px",
        }}
        className={"font-medium styled-button"}
      >
        {buttonLabel}
      </button>
    </>
  );
}
