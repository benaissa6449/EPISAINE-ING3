import { useEffect, useMemo, useState } from "react";
import "./App.css";

type Screen = "home" | "logging" | "recipes";

type KafkaEventEnvelope = {
  topic: string;
  partition: number;
  offset: number;
  key: string | null;
  rawPayload: string;
  customer_id: number | null;
  recipes_id: number[] | null;
  receivedAt: string;
};

type KafkaEventPageResponse = {
  page: number;
  size: number;
  totalItems: number;
  totalPages: number;
  items: KafkaEventEnvelope[];
};

const PAGE_SIZE = 12;

function App() {
  const [screen, setScreen] = useState<Screen>("home");
  return (
    <div className="app-shell">
      {screen === "home" && <HomeView onGo={setScreen} />}
      {screen === "logging" && <LoggingView onBack={() => setScreen("home")} />}
      {screen === "recipes" && <RecipesView onBack={() => setScreen("home")} />}
    </div>
  );
}

function HomeView({
  onGo,
}: {
  onGo: (screen: Screen) => void;
}) {
  return (
    <main className="home">
      <section className="home-card">
        <p className="eyebrow">Episaine Console</p>
        <h1>Monitoring Dashboard</h1>
        <p className="home-description">
          Choisis ton espace pour suivre les flux Kafka et les notifications recettes.
        </p>
        <div className="home-actions">
          <button className="btn primary" onClick={() => onGo("logging")}>
            Logging Monitoring
          </button>
          <button className="btn secondary" onClick={() => onGo("recipes")}>
            Notifications Recipes
          </button>
        </div>
      </section>
    </main>
  );
}

function LoggingView({ onBack }: { onBack: () => void }) {
  const backendBaseUrl = useMemo(
    () => process.env.REACT_APP_BACKEND_URL ?? "",
    []
  );
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);
  const [page, setPage] = useState<number>(0);
  const [payload, setPayload] = useState<KafkaEventPageResponse | null>(null);

  useEffect(() => {
    let cancelled = false;
    const fetchPage = async () => {
      try {
        setLoading(true);
        setError(null);
        const response = await fetch(
          `${backendBaseUrl}/api/events/page?page=${page}&size=${PAGE_SIZE}`
        );
        if (!response.ok) {
          throw new Error(`HTTP ${response.status}`);
        }
        const data = (await response.json()) as KafkaEventPageResponse;
        if (!cancelled) {
          setPayload(data);
        }
      } catch (err) {
        if (!cancelled) {
          setError("Impossible de recuperer les events Kafka.");
        }
      } finally {
        if (!cancelled) {
          setLoading(false);
        }
      }
    };

    fetchPage();
    return () => {
      cancelled = true;
    };
  }, [backendBaseUrl, page]);

  const totalPages = payload?.totalPages ?? 0;
  const canPrev = page > 0;
  const canNext = totalPages > 0 && page < totalPages - 1;

  return (
    <main className="panel">
      <header className="panel-header">
        <button className="btn ghost" onClick={onBack}>
          Retour
        </button>
        <div>
          <p className="eyebrow">Kafka Stream</p>
          <h2>Logging Monitoring</h2>
        </div>
        <button className="btn ghost" onClick={() => setPage(0)}>
          Rafraichir
        </button>
      </header>

      <section className="panel-meta">
        <span>Paquet: {PAGE_SIZE}</span>
        <span>Page: {page + 1}</span>
        <span>Total pages: {totalPages}</span>
        <span>Total items: {payload?.totalItems ?? 0}</span>
      </section>

      {loading && <p className="state">Chargement...</p>}
      {error && <p className="state error">{error}</p>}

      {!loading && !error && (payload?.items.length ?? 0) === 0 && (
        <p className="state">Aucun event disponible pour cette page.</p>
      )}

      <section className="events-grid">
        {payload?.items.map((event) => (
          <article className="event-card" key={`${event.partition}-${event.offset}`}>
            <div className="event-top">
              <strong>{event.topic}</strong>
              <span>offset #{event.offset}</span>
            </div>
            <p>
              customer_id: <b>{event.customer_id ?? "N/A"}</b>
            </p>
            <p>receivedAt: {new Date(event.receivedAt).toLocaleString()}</p>
            <details>
              <summary>Payload JSON</summary>
              <pre>{event.rawPayload}</pre>
            </details>
          </article>
        ))}
      </section>

      <footer className="pagination">
        <button className="btn secondary" disabled={!canPrev} onClick={() => setPage((p) => p - 1)}>
          Precedent
        </button>
        <button className="btn secondary" disabled={!canNext} onClick={() => setPage((p) => p + 1)}>
          Suivant
        </button>
      </footer>
    </main>
  );
}

function RecipesView({ onBack }: { onBack: () => void }) {
  return (
    <main className="panel">
      <header className="panel-header">
        <button className="btn ghost" onClick={onBack}>
          Retour
        </button>
        <div>
          <p className="eyebrow">Recipes Space</p>
          <h2>Notifications Recipes</h2>
        </div>
        <span />
      </header>
      <section className="placeholder">
        <p>Section prete pour ta partie notifications recettes.</p>
      </section>
    </main>
  );
}

export default App;
