from pathlib import Path
import subprocess

from ucimlrepo import fetch_ucirepo


def afficher_infos(df):
    print("Apercu des donnees :")
    print(df.head())
    print("\nNombre de lignes :", len(df))
    print("Nombre de colonnes :", len(df.columns))
    print("Colonnes :", list(df.columns))
    print("\nTypes de donnees :")
    print(df.dtypes)


def creer_dossier_distant(host: str, port: int, remote_dir: str):
    subprocess.run(
        ["ssh", "-p", str(port), host, f"mkdir -p {remote_dir}"],
        check=True,
    )


def envoyer_csv_vers_vm(local_file: Path, host: str, port: int, remote_dir: str):
    creer_dossier_distant(host, port, remote_dir)
    subprocess.run(
        ["scp", "-P", str(port), str(local_file), f"{host}:{remote_dir}/"],
        check=True,
    )


def main():
    cdc = fetch_ucirepo(id=891)
    df = cdc.data.original

    afficher_infos(df)
    print(f"\nNombre total de lignes dans le dataset : {len(df)}")

    output_dir = Path(__file__).resolve().parent
    csv_path = output_dir / "cdc_diabetes_253k.csv"
    xlsm_path = output_dir / "cdc_diabetes_253k.xlsm"

    df.to_csv(csv_path, index=False)
    print(f"\nDonnees CSV sauvegardees dans {csv_path}")

    df.to_excel(xlsm_path, index=False)
    print(f"Donnees XLSM sauvegardees dans {xlsm_path}")

    vm_host = "episaine@172.31.249.46"
    vm_port = 160
    remote_dir = "~/data/uci"
    envoyer_csv_vers_vm(csv_path, vm_host, vm_port, remote_dir)
    print(f"CSV envoye vers {vm_host}:{remote_dir}")


if __name__ == "__main__":
    main()
