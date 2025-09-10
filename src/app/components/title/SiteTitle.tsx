interface SiteTitleProps {
  title: string;
}

export default function SiteTitle({ title }: SiteTitleProps) {
  return (
    <>
      <h1
        style={{
          color: "var(--title-color)",
          fontSize: "70px",
          textAlign: "center",
        }}
        className="font-bold"
      >
        {title}
      </h1>
    </>
  );
}
