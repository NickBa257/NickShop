package modele;

import java.sql.*;
import java.util.ArrayList;

public class Outils {

	static Connection con;
	static ResultSet rs;

	public static ArrayList<Acheteur> getAcheteur() {

		ArrayList<Acheteur> t = new ArrayList<>();
		Acheteur A;

		try {
			con = Db.getConnection();
			rs = Db.Affichage("Select * from Acheteur");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			while (rs.next()) {

				A = new Acheteur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6));
				t.add(A);
			}

			con.close();
			rs.close();

		} catch (Exception e) {

			System.out.println(e);
		}

		return t;
	}

	public static ArrayList<Vendeur> getVendeur() {

		ArrayList<Vendeur> t = new ArrayList<>();
		Vendeur V;

		try {
			con = Db.getConnection();
			rs = Db.Affichage("Select * from Vendeur");
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			while (rs.next()) {

				V = new Vendeur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6));
				t.add(V);
			}

			con.close();
			rs.close();

		} catch (Exception e) {

			System.out.println(e);
		}

		return t;
	}

	public static ArrayList<Produit> getProduit() {

		ArrayList<Produit> t = new ArrayList<>();
		Produit P;

		try {
			con = Db.getConnection();
			rs = Db.Affichage("Select * from Produit");

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			while (rs.next()) {

				P = new Produit(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getString(6), rs.getInt(7));
				t.add(P);
			}

			con.close();
			rs.close();

		} catch (Exception e) {

			System.out.println(e);
		}

		return t;
	}

	public static ArrayList<Commande> getCommande() {

		ArrayList<Commande> t = new ArrayList<>();
		Commande C;

		try {
			con = Db.getConnection();
			rs = Db.Affichage("Select * from Commande");

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			while (rs.next()) {

				C = new Commande(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				t.add(C);
			}

			con.close();
			rs.close();

		} catch (Exception e) {

			System.out.println(e);
		}

		return t;
	}

	public static ArrayList<Bloque> getBloque() {

		ArrayList<Bloque> t = new ArrayList<>();
		Bloque b;

		try {
			con = Db.getConnection();
			rs = Db.Affichage("Select * from Bloque");

		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			while (rs.next()) {
				b = new Bloque(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				t.add(b);
			}

			con.close();
			rs.close();

		} catch (Exception e) {

			System.out.println(e);
		}

		return t;
	}

}
