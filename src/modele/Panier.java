package modele;

public class Panier extends Produit {

	private int quantite;

	public Panier() {

	}

	public Panier(int id, String nom, int quantite, int prix) {

		this.P_id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;

	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

}
