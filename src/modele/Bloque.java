package modele;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bloque {

	private int id;
	private String ip;
	private int tentatives;
	private String date;

	Date d;
	SimpleDateFormat simple;

	public Bloque(int id, String ip, int tentatives, String date) {
		this.id = id;
		this.ip = ip;
		this.tentatives = tentatives;
		this.date = date;
	}

	public Bloque(String ip, int tentatives) {
		this.ip = ip;
		this.tentatives = tentatives;

		d = new Date();
		simple = new SimpleDateFormat("dd/MM/YYYY HH:mm");

		this.date = simple.format(d);
	}

	public void AjoutB() {
		String ajout = " insert into Bloque(ip,Tentatives,Date) values ('" + getIp() + "','" + getTentatives() + "','"
				+ getDate() + "')  ";

		try {
			Db.Modif(ajout);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void ModifB() {

		String modif = "alter table bloque set Tentatives ='" + getTentatives() + "' , Date = '" + getDate()
				+ "' where id='" + getId() + "' ";

		try {
			Db.Modif(modif);
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getTentatives() {
		return tentatives;
	}

	public void setTentatives(int tentatives) {
		this.tentatives = tentatives;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
