import "./StyledButton.css";

interface StyledButtonProps {
  buttonLabel: string;
  onClick: () => void;
  backgroundColor: string;
  borderColor: string;
  buttonTextColor: string;
  fontSize?: number;
}

export default function StyledButton({
  buttonLabel,
  onClick,
  fontSize,
  backgroundColor,
  borderColor,
  buttonTextColor,
}: StyledButtonProps) {
  return (
    <>
      <button
        onClick={onClick}
        style={{
          fontSize: fontSize !== undefined ? `${fontSize}px` : "20px",
          backgroundColor: `var(--${backgroundColor})`,
          border: `4px solid var(--${borderColor})`,
          color: `var(--${buttonTextColor})`,
        }}
        className={"font-medium styled-button"}
      >
        {buttonLabel}
      </button>
    </>
  );
}
