interface VerticalSpacerProps {
  height: number;
}

export default function VerticalSpacer({ height }: VerticalSpacerProps) {
  return (
    <>
      <div style={{ marginTop: height }}></div>
    </>
  );
}
