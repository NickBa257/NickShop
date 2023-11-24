package modele;

import java.sql.SQLException;

public class Acheteur {
	
	private String nom,adresse,ident,pass;
	private int id,tel;
	

	
	public Acheteur(String nom, String adresse, int tel, String ident, String pass) {
		this.nom = nom;
		this.adresse = adresse;
		this.ident = ident;
		this.pass = pass;
		this.tel = tel;
	}


	public Acheteur(String ident, String pass) {
		this.ident = ident;
		this.pass = pass;
	}


	public Acheteur(int id,String nom,String adresse,int tel,String ident,String pass) {
		this.id=id;
		this.nom = nom;
		this.adresse = adresse;
		this.tel = tel;
		this.ident=ident;
		this.pass=pass;
	}
	
	public void AjoutA() throws SQLException {

	String ajout = "insert into acheteur(Nom,Adresse,Telephone,identifiant,mot_de_passe) values('"+getNom()+"','"+getAdresse()+"','"+getTel()+"','"+getIdent()+"','"+getPass()+"')";

		Db.Modif(ajout);

	}

	public void ModifA() throws SQLException {
		
		String modif = "update acheteur set Nom='" + getNom() + "',Adresse='" + getAdresse()
				+ "',Telephone='" + getTel() + "',identifiant='" + getIdent() + "',mot_de_passe='"
				+ getPass() + "' " + "where AId='" +getId() + "' ";

		Db.Modif(modif);	
	}

	public void SuppA() throws SQLException {
		String supp = "delete from acheteur where AId='" + getId()+ "' ";

		Db.Modif(supp);
		
	}
	
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public String getIdent() {
		return ident;
	}


	public void setIdent(String ident) {
		this.ident = ident;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}
	


}
