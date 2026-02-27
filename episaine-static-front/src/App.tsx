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

type WeeklyKpiResponse = {
  week_start: string;
  week_end: string;
  connexions: number;
  deconnexions: number;
  navigations: number;
  total_events: number;
};

type EventCategory = "connexion" | "deconnexion" | "navigation" | "profile";

type InAppNotification = {
  id: number;
  customerId: number;
  title: string;
  message: string;
  recipeIds: number[];
  isRead: boolean;
  createdAt: string;
  expiresAt: string;
};

type Recipe = {
  id: number;
  mealName: string | null;
  category: string | null;
  calories: number | null;
  ingredients: string | null;
  instructions: string | null;
  areaId: number | null;
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
    () => "",
    []
  );
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);
  const [page, setPage] = useState<number>(0);
  const [allEvents, setAllEvents] = useState<KafkaEventEnvelope[]>([]);
  const [showTechnical, setShowTechnical] = useState<boolean>(false);
  const [weeklyKpi, setWeeklyKpi] = useState<WeeklyKpiResponse | null>(null);
  const [weeklyKpiLoading, setWeeklyKpiLoading] = useState<boolean>(false);
  const [weeklyKpiError, setWeeklyKpiError] = useState<string | null>(null);
  const [searchText, setSearchText] = useState<string>("");
  const [typeFilter, setTypeFilter] = useState<"all" | EventCategory>("all");

  const fetchAllEvents = useCallback(async () => {
    try {
      setLoading(true);
      setError(null);
      const response = await fetch(`${backendBaseUrl}/api/events/latest?limit=5000`);
      if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
      }
      const data = (await response.json()) as KafkaEventEnvelope[];
      setAllEvents([...data].reverse());
    } catch {
      setError("Impossible de recuperer les events Kafka.");
    } finally {
      setLoading(false);
    }
  }, [backendBaseUrl]);

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
    void fetchAllEvents();
  }, [fetchAllEvents]);

  useEffect(() => {
    const intervalId = window.setInterval(() => {
      void fetchAllEvents();
    }, POLL_INTERVAL_MS);
    return () => window.clearInterval(intervalId);
  }, [fetchAllEvents]);

  useEffect(() => {
    void fetchWeeklyKpi();
  }, [fetchWeeklyKpi]);

  useEffect(() => {
    const intervalId = window.setInterval(() => {
      void fetchWeeklyKpi();
    }, POLL_INTERVAL_MS);
    return () => window.clearInterval(intervalId);
  }, [fetchWeeklyKpi]);

  const totalItemsBeforeFilter = allEvents.length;
  const items = useMemo(() => allEvents, [allEvents]);
  const normalizedQuery = useMemo(() => normalizeText(searchText), [searchText]);
  const filteredItems = useMemo(() => {
    return items.filter((event) => {
      const category = getEventCategory(event);
      const typeMatches = typeFilter === "all" || category === typeFilter;
      const userMatches =
        normalizedQuery.length === 0 ||
        normalizeText(formatUser(event.user_id)).includes(normalizedQuery);
      return typeMatches && userMatches;
    });
  }, [items, normalizedQuery, typeFilter]);
  const totalItems = filteredItems.length;
  const totalPages = totalItems === 0 ? 0 : Math.ceil(totalItems / PAGE_SIZE);
  const pageStart = page * PAGE_SIZE;
  const pagedItems = useMemo(
    () => filteredItems.slice(pageStart, pageStart + PAGE_SIZE),
    [filteredItems, pageStart]
  );

  useEffect(() => {
    setPage(0);
  }, [searchText, typeFilter]);

  useEffect(() => {
    if (totalPages > 0 && page >= totalPages) {
      setPage(totalPages - 1);
    }
  }, [page, totalPages]);

  const canPrev = page > 0;
  const canNext = totalPages > 0 && page < totalPages - 1;

  const stats = useMemo(() => {
    return pagedItems.reduce(
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
  }, [pagedItems]);

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
          <button className="btn ghost" onClick={() => { setPage(0); void fetchAllEvents(); }}>
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
        <span>Total items filtres: {totalItems}</span>
        <span>Total source: {totalItemsBeforeFilter}</span>
        <span>Connexions: {stats.connexion}</span>
        <span>Deconnexions: {stats.deconnexion}</span>
        <span>Navigations: {stats.navigation}</span>
        <span>Profils: {stats.profile}</span>
      </section>

      <section className="filters-panel">
        <input
          className="filters-input"
          type="text"
          placeholder="Rechercher par nom ou prenom (Qui)"
          value={searchText}
          onChange={(e) => setSearchText(e.target.value)}
        />
        <select
          className="filters-select"
          value={typeFilter}
          onChange={(e) => setTypeFilter(e.target.value as "all" | EventCategory)}
        >
          <option value="all">Tous les types</option>
          <option value="connexion">Connexion</option>
          <option value="deconnexion">Deconnexion</option>
          <option value="navigation">Navigation</option>
          <option value="profile">Profil client</option>
        </select>
        <span className="filters-count">Resultats: {filteredItems.length}</span>
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

      {!loading && !error && filteredItems.length === 0 && (
        <p className="state">Aucun event disponible pour cette page.</p>
      )}

      <section className="events-grid">
        {pagedItems.map((event) => {
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
  const notificationBaseUrl = useMemo(
    () => process.env.REACT_APP_NOTIFICATIONS_URL ?? "",
    []
  );

  const [customerIdInput, setCustomerIdInput] = useState<string>("");
  const [connectedCustomerId, setConnectedCustomerId] = useState<number | null>(null);
  const [notifications, setNotifications] = useState<InAppNotification[]>([]);
  const [recipes, setRecipes] = useState<Recipe[]>([]);
  const [loading, setLoading] = useState<boolean>(false);
  const [error, setError] = useState<string | null>(null);

  const fetchCustomerData = useCallback(async (customerId: number) => {
    try {
      setLoading(true);
      setError(null);

      const [notificationsResponse, recipesResponse] = await Promise.all([
        fetch(`${notificationBaseUrl}/api/notifications/customer/${customerId}`),
        fetch(`${notificationBaseUrl}/api/notifications/customer/${customerId}/recipes`),
      ]);

      if (!notificationsResponse.ok) {
        throw new Error(`notifications HTTP ${notificationsResponse.status}`);
      }
      if (!recipesResponse.ok) {
        throw new Error(`recipes HTTP ${recipesResponse.status}`);
      }

      const notificationsData = (await notificationsResponse.json()) as InAppNotification[];
      const recipesData = (await recipesResponse.json()) as Recipe[];
      setNotifications(notificationsData);
      setRecipes(recipesData);
    } catch (error) {
      const message = error instanceof Error ? error.message : "Erreur inconnue";
      setError(`Impossible de charger les notifications de ce client (${message}).`);
    } finally {
      setLoading(false);
    }
  }, [notificationBaseUrl]);

  const connectCustomer = useCallback(async () => {
    const parsed = Number(customerIdInput);
    if (!Number.isInteger(parsed) || parsed <= 0) {
      setError("Saisis un id client numerique valide.");
      return;
    }

    setConnectedCustomerId(parsed);
    await fetchCustomerData(parsed);
  }, [customerIdInput, fetchCustomerData]);

  const disconnectCustomer = useCallback(() => {
    setConnectedCustomerId(null);
    setCustomerIdInput("");
    setNotifications([]);
    setRecipes([]);
    setError(null);
  }, []);

  const markAsRead = useCallback(async (notificationId: number) => {
    if (connectedCustomerId === null) {
      return;
    }

    try {
      const response = await fetch(`${notificationBaseUrl}/api/notifications/${notificationId}/read`, {
        method: "PUT",
      });
      if (!response.ok) {
        throw new Error(`HTTP ${response.status}`);
      }
      await fetchCustomerData(connectedCustomerId);
    } catch (error) {
      const message = error instanceof Error ? error.message : "Erreur inconnue";
      setError(`Impossible de mettre la notification en lu (${message}).`);
    }
  }, [connectedCustomerId, fetchCustomerData, notificationBaseUrl]);

  useEffect(() => {
    if (connectedCustomerId === null) {
      return;
    }
    const intervalId = window.setInterval(() => {
      void fetchCustomerData(connectedCustomerId);
    }, POLL_INTERVAL_MS);
    return () => window.clearInterval(intervalId);
  }, [connectedCustomerId, fetchCustomerData]);

  const recipesById = useMemo(() => {
    return new Map<number, Recipe>(recipes.map((recipe) => [recipe.id, recipe]));
  }, [recipes]);

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
        <div className="header-actions">
          {connectedCustomerId !== null && (
            <button className="btn ghost" onClick={() => void fetchCustomerData(connectedCustomerId)}>
              Rafraichir
            </button>
          )}
        </div>
      </header>

      <section className="customer-connect">
        <label htmlFor="customer-id">ID client</label>
        <input
          id="customer-id"
          className="filters-input"
          type="number"
          min={1}
          placeholder="Ex: 42"
          value={customerIdInput}
          onChange={(e) => setCustomerIdInput(e.target.value)}
        />
        <button className="btn primary" onClick={() => void connectCustomer()}>
          Se connecter
        </button>
        <button
          className="btn secondary"
          onClick={disconnectCustomer}
          disabled={connectedCustomerId === null}
        >
          Deconnexion
        </button>
      </section>

      {connectedCustomerId !== null && (
        <section className="panel-meta">
          <span>Client connecte: {connectedCustomerId}</span>
          <span>Notifications: {notifications.length}</span>
          <span>Recettes: {recipes.length}</span>
          <span>Refresh: {POLL_INTERVAL_MS / 1000}s</span>
        </section>
      )}

      {loading && <p className="state">Chargement...</p>}
      {error && <p className="state error">{error}</p>}

      {!loading && connectedCustomerId !== null && notifications.length === 0 && !error && (
        <section className="placeholder">
          <p>Aucune notification active pour ce client.</p>
        </section>
      )}

      {connectedCustomerId !== null && notifications.length > 0 && (
        <section className="recipes-notifications">
          {notifications.map((notification) => (
            <article className="event-card" key={notification.id}>
              <div className="event-top">
                <strong>{notification.title}</strong>
                <span className={`event-badge ${notification.isRead ? "profile" : "navigation"}`}>
                  {notification.isRead ? "Lu" : "Non lu"}
                </span>
              </div>
              <p className="event-summary">{notification.message}</p>
              <p><b>Creee le:</b> {new Date(notification.createdAt).toLocaleString()}</p>
              <p><b>Expire le:</b> {new Date(notification.expiresAt).toLocaleString()}</p>
              <div className="notification-actions">
                {!notification.isRead && (
                  <button className="btn secondary" onClick={() => void markAsRead(notification.id)}>
                    Marquer comme lu
                  </button>
                )}
              </div>
              <div className="recipes-list">
                {notification.recipeIds.map((recipeId) => {
                  const recipe = recipesById.get(recipeId);
                  if (!recipe) {
                    return (
                      <div className="recipe-chip" key={`${notification.id}-${recipeId}`}>
                        Recette #{recipeId} (details indisponibles)
                      </div>
                    );
                  }
                  return (
                    <div className="recipe-chip" key={`${notification.id}-${recipe.id}`}>
                      <strong>{recipe.mealName ?? `Recette #${recipe.id}`}</strong>
                      <span>{recipe.category ?? "Sans categorie"}</span>
                      <span>{recipe.calories ?? "?"} kcal</span>
                    </div>
                  );
                })}
              </div>
            </article>
          ))}
        </section>
      )}

      {connectedCustomerId === null && (
        <section className="placeholder">
          <p>Entre un id client puis clique sur "Se connecter".</p>
        </section>
      )}

      <section className="recipes-catalog">
        <h3>Recettes completes recuperees</h3>
        {recipes.length === 0 ? (
          <p className="state">Aucune recette chargee.</p>
        ) : (
          <div className="events-grid">
            {recipes.map((recipe) => (
              <article className="event-card" key={recipe.id}>
                <div className="event-top">
                  <strong>{recipe.mealName ?? `Recette #${recipe.id}`}</strong>
                  <span className="event-badge profile">{recipe.calories ?? "?"} kcal</span>
                </div>
                <p><b>Categorie:</b> {recipe.category ?? "N/A"}</p>
                <p><b>Ingredients:</b> {recipe.ingredients ?? "N/A"}</p>
                <p><b>Instructions:</b> {recipe.instructions ?? "N/A"}</p>
              </article>
            ))}
          </div>
        )}
      </section>
    </main>
  );
}

function getEventCategory(event: KafkaEventEnvelope): EventCategory {
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

function normalizeText(value: string): string {
  return value
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, "")
    .toLowerCase()
    .trim();
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
