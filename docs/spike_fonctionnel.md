# EPISAINE — Spike Fonctionnel
## Proposition de plats sains & Gestion client

---

### 2.1 Cas d'usage principal

**Traiter et analyser les données clients**  
```
```

### 2.2 Segmentation client identifiée

D'après les données source CDC Diabetes et les profils clients, les segments sont :

| Segment | Critères source | Impact sur recommandation |
|---------|----------------|--------------------------|
| **Diabétique** | `Diabetes_binary = 1` | Plats à index glycémique bas, pas de sucres ajoutés |
| **Obèse** | `BMI > 30` | Plats hypocaloriques, portions contrôlées |
| **Hypertendu** | `HighBP = 1` | Plats pauvres en sodium |
| **Cholestérol élevé** | `HighChol = 1` | Plats pauvres en graisses saturées, riches en oméga-3 |
| **Fumeur** | `Smoker = yes` | Plats riches en antioxydants, vitamines C/E |
| **Sédentaire** | `PhysActivity = no` | Plats légers, faible densité calorique |
| **Ne mange pas de fruits** | `Fruits = no` | Compenser par des recettes intégrant des fruits |
| **Ne mange pas de légumes** | `Veggies = no` | Proposer des recettes attractives à base de légumes |
| **Consommateur d'alcool** | `HvyAlcoholConsump = yes` | Plats détox, riches en vitamines B |
| **Santé mentale fragile** | `MentHlth > 15 jours` | Plats comfort food sains, riches en magnésium et oméga-3 |

### 2.3 Parcours utilisateur cible

| Étape | Acteur | Action | Système |
|-------|--------|--------|---------|
| 1 | Système | Analyse profil santé | Lecture `gold.silver_snapshot` |
| 2 | Système | Détecte conditions (diabète, obésité…) | Règles de segmentation |
| 3 | Système | Sélectionne recettes adaptées | Filtres allergies + diet_type + conditions |
| 4 | Système | Génère notification personnalisée | Service de génération |

### 2.4 Définition précise des indicateurs métier

#### Mesures principales

| Indicateur | Tables/Attributs | Règle de calcul |
|-----------|-----------------|----------------|
| Taux de diabète | `gold.silver_snapshot` → `diabetes_binary` | `COUNT(diabetes_binary = 'prediabetes or diabetes') / COUNT(*)` |
| BMI moyen | `gold.silver_snapshot` → [bmi](file:///c:/Users/Ismail%20Benaissa/Desktop/EPISAINE-ING3/Mock/customers-mock/app/customers_mock.py#104-110) | `AVG(bmi)` |
| Taux d'activité physique | `gold.silver_snapshot` → `physactivity` | `COUNT(physactivity = 'yes') / COUNT(*)` |
| Consommation fruits & légumes | `gold.silver_snapshot` → `fruits`, `veggies` | `COUNT(fruits='yes' AND veggies='yes') / COUNT(*)` |
| Score santé global | `gold.silver_snapshot` → `genhlth` | `5 - AVG(genhlth_code)` (inversé) |
| Prévalence multi-risques | `diabetes_binary`, `highbp`, `highchol` | `COUNT(3 conditions réunies) / COUNT(*)` |

#### Dimensions d'analyse

| Dimension | Source | Niveaux hiérarchiques |
|-----------|--------|----------------------|
| **Âge** | `age` (13 tranches) | Global → Tranche d'âge |
| **Sexe** | `sex` | Homme / Femme |
| **Éducation** | `education` (6 niveaux) | Global → Niveau d'éducation |
| **Revenu** | `income` (8 tranches) | Global → Tranche de revenu |
| **Santé générale** | `genhlth` (5 niveaux) | Excellent → Poor |

### 2.5 Hiérarchies pour le Drilldown

Les hiérarchies de drilldown permettent aux décideurs de naviguer du niveau le plus général au plus fin. Voici les hiérarchies définies pour le projet :

- **Âge** : On part de la population totale, puis on descend vers les 13 tranches d'âge (18-24, 25-29, 30-34, … jusqu'à 80+). Cela permet d'identifier les tranches les plus à risque (ex : prévalence du diabète chez les 60-64 ans vs 18-24 ans).

- **Santé** : On part de l'ensemble des clients, on filtre d'abord par statut diabétique (oui/non), puis on affine vers les profils multi-risques combinant hypertension (`HighBP`), cholestérol élevé (`HighChol`) et BMI élevé. Cela permet de cibler les clients nécessitant des recommandations alimentaires les plus urgentes.

- **Éducation** : On part du niveau global, puis on descend dans les 6 niveaux (de « jamais scolarisé » à « diplômé universitaire »). Cette hiérarchie aide à adapter le niveau de complexité des recommandations nutritionnelles.

- **Revenu** : On part du global, puis on descend dans les 8 tranches de revenu (de moins de $10K à plus de $75K). Le revenu influence directement l'accessibilité des ingrédients recommandés et le type de plats proposés.

- **Santé générale** : On part du score global (`GenHlth`) et on descend dans les 5 niveaux (excellent, very good, good, fair, poor). Les clients en santé « fair » ou « poor » sont prioritaires pour les recommandations.

### 2.6 Hypothèses de réutilisation des données

- Les **253K enregistrements** CDC Diabetes permettent de simuler une base client réaliste avec des profils de santé variés
- Les conditions médicales dérivées (`DIABETES`, `OBESITY`, `HYPERTENSION`, `HIGH_CHOLESTEROL`) servent directement à la **segmentation pour les recettes**
- Le `diet_type` (13 régimes : Vegan, Keto, Mediterranean, DASH, etc.) guide l'algorithme de recommandation
- Les colonnes `Fruits` et `Veggies` identifient les clients dont l'alimentation doit être **rééquilibrée en priorité**
- Le `BMI` combiné au `PhysActivity` permet de définir un **objectif de poids** (perte, maintien, gain) et d'adapter les portions
