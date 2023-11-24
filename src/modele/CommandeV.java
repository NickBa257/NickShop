package modele;

import java.sql.SQLException;

public class CommandeV {

	private int id;
	private String NProduit;
	private int quantite;
	private int PrixTotal;
	private String NClient;
	private String date;
	private boolean effectue;

	public CommandeV(int id, String nProduit, int quantite, int prixTotal, String nClient, String date,
			boolean effectue) {
		this.id = id;
		NProduit = nProduit;
		this.quantite = quantite;
		PrixTotal = prixTotal;
		NClient = nClient;
		this.date = date;
		this.effectue = effectue;
	}

	public CommandeV(String nProduit, int quantite, int prixTotal, String nClient, String date) {
		NProduit = nProduit;
		this.quantite = quantite;
		PrixTotal = prixTotal;
		NClient = nClient;
		this.date = date;
		this.effectue = false;
	}

	public void Ajout() throws SQLException {

		String ajout = " insert into commandeV (NomProduit,Quantite,PrixTotal,NomClient,Date_Commande,Effectue) values('" + getNProduit() + "','"+getQuantite()+"', '"+getPrixTotal()+"' , '" + getNClient() + "', '"
				+ getDate() + "', '" +isEffectue() + "')  ";

		Db.Modif(ajout);

	}

	public void ModifC() throws SQLException{

		String ajout = " insert into commande (NomProduit,NomClient,PrixTotal,Date_Commande) values('" + getNProduit()
				+ "','" + getNClient() + "', '" + getPrixTotal() + "', '" + getDate() + "')  ";

		Db.Modif(ajout);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNProduit() {
		return NProduit;
	}

	public void setNProduit(String nProduit) {
		NProduit = nProduit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrixTotal() {
		return PrixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		PrixTotal = prixTotal;
	}

	public String getNClient() {
		return NClient;
	}

	public void setNClient(String nClient) {
		NClient = nClient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isEffectue() {
		return effectue;
	}

	public void setEffectue(boolean effectue) {
		this.effectue = effectue;
	}

}
