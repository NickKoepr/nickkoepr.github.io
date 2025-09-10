interface SegmentTitleProps {
  title: string;
}

export default function SegmentTitle({ title }: SegmentTitleProps) {
  return (
    <>
      <h2
        style={{
          textAlign: "center",
          color: "var(--segment-title-color)",
          fontSize: "45px",
        }}
        className="font-bold"
      >
        {title}
      </h2>
    </>
  );
}
