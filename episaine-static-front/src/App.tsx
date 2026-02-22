import { useCallback, useEffect, useMemo, useState } from "react";
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
  event_type: string | null;
  user_id: string | null;
  route: string | null;
  event_at: string | null;
  session_started_at: string | null;
  session_duration_seconds: number | null;
  receivedAt: string;
};

type KafkaEventPageResponse = {
  page: number;
  size: number;
  totalItems: number;
  totalPages: number;
  items: KafkaEventEnvelope[];
};

type WeeklyKpiResponse = {
  week_start: string;
  week_end: string;
  connexions: number;
  deconnexions: number;
  navigations: number;
  total_events: number;
};

const PAGE_SIZE = 12;
const POLL_INTERVAL_MS = 5000;

function App() {
  const [screen, setScreen] = useState<Screen>("home");
  return (
    <div className="app-shell">
      {screen === "home" && <HomeView onGo={setScreen} />}
      {screen === "logging" && (
        <LoggingView onBack={() => setScreen("home")} />
      )}
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
  const [showTechnical, setShowTechnical] = useState<boolean>(false);
  const [weeklyKpi, setWeeklyKpi] = useState<WeeklyKpiResponse | null>(null);
  const [weeklyKpiLoading, setWeeklyKpiLoading] = useState<boolean>(false);
  const [weeklyKpiError, setWeeklyKpiError] = useState<string | null>(null);

  const fetchPage = useCallback(async () => {
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
      setPayload(data);
    } catch {
      setError("Impossible de recuperer les events Kafka.");
    } finally {
      setLoading(false);
    }
  }, [backendBaseUrl, page]);

  const fetchWeeklyKpi = useCallback(async () => {
    try {
      setWeeklyKpiLoading(true);
      setWeeklyKpiError(null);
      const response = await fetch(`${backendBaseUrl}/api/events/kpi/weekly`);
      if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
      }
      const data = (await response.json()) as WeeklyKpiResponse;
      setWeeklyKpi(data);
    } catch {
      setWeeklyKpiError("Impossible de charger les KPI hebdomadaires.");
    } finally {
      setWeeklyKpiLoading(false);
    }
  }, [backendBaseUrl]);

  useEffect(() => {
    void fetchPage();
  }, [fetchPage]);

  useEffect(() => {
    const intervalId = window.setInterval(() => {
      void fetchPage();
    }, POLL_INTERVAL_MS);
    return () => window.clearInterval(intervalId);
  }, [fetchPage]);

  useEffect(() => {
    void fetchWeeklyKpi();
  }, [fetchWeeklyKpi]);

  useEffect(() => {
    const intervalId = window.setInterval(() => {
      void fetchWeeklyKpi();
    }, POLL_INTERVAL_MS);
    return () => window.clearInterval(intervalId);
  }, [fetchWeeklyKpi]);

  const totalPages = payload?.totalPages ?? 0;
  const canPrev = page > 0;
  const canNext = totalPages > 0 && page < totalPages - 1;
  const items = useMemo(() => payload?.items ?? [], [payload]);

  const stats = useMemo(() => {
    return items.reduce(
      (acc, event) => {
        const category = getEventCategory(event);
        if (category === "connexion") acc.connexion += 1;
        if (category === "deconnexion") acc.deconnexion += 1;
        if (category === "navigation") acc.navigation += 1;
        if (category === "profile") acc.profile += 1;
        return acc;
      },
      { connexion: 0, deconnexion: 0, navigation: 0, profile: 0 }
    );
  }, [items]);

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
        <div className="header-actions">
          <button className="btn ghost" onClick={() => setPage(0)}>
            Rafraichir
          </button>
          <button className="btn ghost" onClick={() => void fetchWeeklyKpi()}>
            KPI semaine
          </button>
          <button className="btn ghost" onClick={() => setShowTechnical((v) => !v)}>
            {showTechnical ? "Mode metier" : "Mode expert"}
          </button>
        </div>
      </header>

      <section className="panel-meta">
        <span>Paquet: {PAGE_SIZE}</span>
        <span>Refresh: {POLL_INTERVAL_MS / 1000}s</span>
        <span>Page: {page + 1}</span>
        <span>Total pages: {totalPages}</span>
        <span>Total items: {payload?.totalItems ?? 0}</span>
        <span>Connexions: {stats.connexion}</span>
        <span>Deconnexions: {stats.deconnexion}</span>
        <span>Navigations: {stats.navigation}</span>
        <span>Profils: {stats.profile}</span>
      </section>

      {(weeklyKpiLoading || weeklyKpiError || weeklyKpi) && (
        <section className="kpi-weekly">
          <h3>KPI hebdomadaire</h3>
          {weeklyKpiLoading && <p>Chargement KPI...</p>}
          {weeklyKpiError && <p className="state error">{weeklyKpiError}</p>}
          {weeklyKpi && (
            <>
              <div className="kpi-grid">
                <span>Semaine: {weeklyKpi.week_start} au {weeklyKpi.week_end}</span>
                <span>Total events semaine: {weeklyKpi.total_events}</span>
              </div>
              <KpiBarChart
                connexions={weeklyKpi.connexions}
                deconnexions={weeklyKpi.deconnexions}
                navigations={weeklyKpi.navigations}
              />
            </>
          )}
        </section>
      )}

      {loading && <p className="state">Chargement...</p>}
      {error && <p className="state error">{error}</p>}

      {!loading && !error && (payload?.items.length ?? 0) === 0 && (
        <p className="state">Aucun event disponible pour cette page.</p>
      )}

      <section className="events-grid">
        {items.map((event) => {
          const category = getEventCategory(event);
          const label = getEventLabel(category);
          return (
          <article className="event-card" key={`${event.partition}-${event.offset}`}>
            <div className="event-top">
              <strong>{label}</strong>
              <span className={`event-badge ${category}`}>{label}</span>
            </div>
            <p className="event-summary">{buildBusinessSummary(event, category)}</p>
            <p><b>Quand:</b> {new Date(event.event_at ?? event.receivedAt).toLocaleString()}</p>
            <p><b>Qui:</b> {formatUser(event.user_id)}</p>
            <p><b>Ecran:</b> {formatRoute(event.route)}</p>
            <p><b>Client:</b> {formatCustomer(event.customer_id)}</p>
            {event.session_started_at && (
              <p><b>Debut session:</b> {new Date(event.session_started_at).toLocaleString()}</p>
            )}
            {category === "deconnexion" &&
              event.session_duration_seconds !== null &&
              event.session_duration_seconds !== undefined && (
              <p><b>Duree session:</b> {formatDuration(event.session_duration_seconds)}</p>
            )}
            {showTechnical && (
              <details>
                <summary>Details techniques</summary>
                <p>Topic: {event.topic}</p>
                <p>Partition: {event.partition}</p>
                <p>Offset: {event.offset}</p>
                <p>Recu a: {new Date(event.receivedAt).toLocaleString()}</p>
                <pre>{event.rawPayload}</pre>
              </details>
            )}
          </article>
        )})}
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

function getEventCategory(event: KafkaEventEnvelope): "connexion" | "deconnexion" | "navigation" | "profile" {
  if (event.event_type === "connexion") return "connexion";
  if (event.event_type === "deconnexion") return "deconnexion";
  if (event.event_type === "navigation") return "navigation";
  return "profile";
}

function getEventLabel(category: "connexion" | "deconnexion" | "navigation" | "profile"): string {
  if (category === "connexion") return "Connexion";
  if (category === "deconnexion") return "Deconnexion";
  if (category === "navigation") return "Navigation";
  return "Profil client";
}

function buildBusinessSummary(
  event: KafkaEventEnvelope,
  category: "connexion" | "deconnexion" | "navigation" | "profile"
): string {
  if (category === "connexion") return `Utilisateur ${event.user_id ?? "inconnu"} connecte.`;
  if (category === "deconnexion") return `Utilisateur ${event.user_id ?? "inconnu"} deconnecte.`;
  if (category === "navigation") return `Navigation vers ${event.route ?? "un ecran inconnu"}.`;
  return `Mise a jour du profil client ${event.customer_id ?? "inconnu"}.`;
}

function formatUser(userId: string | null): string {
  if (!userId || userId.trim() === "") {
    return "inconnu";
  }
  return userId;
}

function formatRoute(route: string | null): string {
  if (!route || route.trim() === "") {
    return "activite interne";
  }
  return route;
}

function formatCustomer(customerId: number | null): string {
  if (customerId === null || customerId === undefined) {
    return "non specifie";
  }
  return String(customerId);
}

function formatDuration(durationSeconds: number): string {
  const seconds = Math.max(0, durationSeconds);
  const minutes = Math.floor(seconds / 60);
  const remainingSeconds = seconds % 60;
  if (minutes === 0) {
    return `${remainingSeconds}s`;
  }
  return `${minutes}m ${remainingSeconds}s`;
}

function KpiBarChart({
  connexions,
  deconnexions,
  navigations,
}: {
  connexions: number;
  deconnexions: number;
  navigations: number;
}) {
  const maxValue = Math.max(connexions, deconnexions, navigations, 1);
  const bars = [
    { key: "connexions", label: "Connexions", value: connexions },
    { key: "deconnexions", label: "Deconnexions", value: deconnexions },
    { key: "navigations", label: "Navigations", value: navigations },
  ];

  return (
    <div className="kpi-chart">
      {bars.map((bar) => (
        <div className="kpi-chart-item" key={bar.key}>
          <div className="kpi-chart-label">{bar.label}</div>
          <div className="kpi-chart-track">
            <div
              className={`kpi-chart-fill ${bar.key}`}
              style={{ width: `${(bar.value / maxValue) * 100}%` }}
            />
          </div>
          <div className="kpi-chart-value">{bar.value}</div>
        </div>
      ))}
    </div>
  );
}

export default App;
