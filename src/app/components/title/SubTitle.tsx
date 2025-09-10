interface SubTitleProps {
  text: string;
}

export default function SubTitle({ text }: SubTitleProps) {
  return (
    <>
      <p
        style={{
          textAlign: "center",
          color: "var(--subtitle-color)",
          fontSize: "30px",
          marginTop: "-5px",
        }}
        className="font-medium"
      >
        {text}
      </p>
    </>
  );
}
