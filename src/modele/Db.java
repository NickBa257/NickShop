package modele;

import java.sql.*;

public class Db {

	public static Connection getConnection()throws SQLException,ClassNotFoundException {

		Connection con = null;

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vente_en_ligne", "root", "");

		return con;
	}

	public static void Modif(String sql) throws SQLException {

		Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st = null;

		
			st = con.createStatement();
			st.executeUpdate(sql);
	
	}

	public static ResultSet Affichage(String sql) throws SQLException  {
		Connection con = null;
		try {
			con = getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st = null;
		ResultSet rs = null;

		
			st = con.createStatement();
			rs = st.executeQuery(sql);
		

		return rs;
	}

}
