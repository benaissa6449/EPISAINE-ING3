from ucimlrepo import fetch_ucirepo

# Importer le dataset CDC Diabetes Health Indicators (ID: 891)
cdc = fetch_ucirepo(id=891)

df = cdc.data.original

# Afficher les informations principales
def afficher_infos(df):
    print("Aperçu des données :")
    print(df.head())
    print("\nNombre de lignes :", len(df))
    print("Nombre de colonnes :", len(df.columns))
    print("Colonnes :", list(df.columns))
    print("\nTypes de données :")
    print(df.dtypes)


afficher_infos(df)
print(f"\nNombre total de lignes dans le dataset : {len(df)}")

# Sauvegarder le dataset en CSV
csv_filename = "cdc_diabetes_253k.csv"
df.to_csv(csv_filename, index=False)
print(f"\nDonnées sauvegardées dans {csv_filename}")
