package modele;

import java.sql.SQLException;

public class Commande {

	private int id;
	private String NProduit;
	private String NClient;
	private int PrixTotal;
	private String date;

	public Commande(String nProduit, String nClient, int prixTotal, String date) {
		NProduit = nProduit;
		NClient = nClient;
		PrixTotal = prixTotal;
		this.date = date;
	}

	public Commande(int id, String nP, String nC, int prixtotal, String date) {
		this.id = id;
		NProduit = nP;
		NClient = nC;
		PrixTotal = prixtotal;
		this.date = date;
	}

	public void Ajout() throws SQLException {

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

	public String getNClient() {
		return NClient;
	}

	public void setNClient(String nClient) {
		NClient = nClient;
	}

	public int getPrixTotal() {
		return PrixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		PrixTotal = prixTotal;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
