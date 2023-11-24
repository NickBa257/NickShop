package modele;

import java.sql.SQLException;

public class Produit {

	protected int P_id;
	protected String nom;
	protected String categorie;
	private int quantite;
	protected int prix;
	protected String image;
	protected int VId;

	Produit() {

	}

	public Produit(int p_id, String nom, int prix) {
		super();
		P_id = p_id;
		this.nom = nom;
		this.prix = prix;
	}

	public Produit(int p_id, String nom, String categorie, int quantite, int prix, String image, int vId) {
		P_id = p_id;
		this.nom = nom;
		this.categorie = categorie;
		this.quantite = quantite;
		this.prix = prix;
		this.image = image;
		VId = vId;
	}

	public Produit(String nom, String categorie, int quantite, int prix, String image, int vId) {
		this.nom = nom;
		this.categorie = categorie;
		this.quantite = quantite;
		this.prix = prix;
		this.image = image;
		VId = vId;
	}

	public void AjoutP() throws SQLException {

		String ajout = "insert into Produit(Nom,categorie,quantite,prix,image,VId) values('" + getNom() + "','"
				+ getCategorie() + "','" + getQuantite() + "','" + getPrix() + "','" + getImage() + "', '" + getVId()
				+ "')";

		Db.Modif(ajout);
	}

	public void modifP()  throws SQLException  {

		String modif = "update produit set Nom='" + getNom() + "' , categorie = '" + getCategorie() + "', quantite='"
				+ getQuantite() + "', prix='" + getPrix() + "', image ='" + getImage() + "'  where Produit_id ='" + getP_id()
				+ "' ";

		Db.Modif(modif);
	}
	
	public void SuppP()  throws SQLException  {

		String supp = "delete from produit where Produit_id ='" + getP_id() + "' ";
		Db.Modif(supp);
	}

	public int getP_id() {
		return P_id;
	}

	public void setP_id(int p_id) {
		P_id = p_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getVId() {
		return VId;
	}

	public void setVId(int vId) {
		VId = vId;
	}

}
