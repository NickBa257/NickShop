package controlleur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Acheteur;
import modele.Commande;
import modele.CommandeV;
import modele.Db;
import modele.Outils;
import modele.Panier;
import modele.Produit;

@WebServlet("/CommandeS")
public class CommandeS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	Connection con = null;

	Commande c = null;
	CommandeV cv = null;

	Acheteur a = null;
	ArrayList<Produit> tabP;
	ArrayList<Panier> tabPa;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int total = Integer.parseInt(request.getParameter("total"));

		try {
			con = Db.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session = request.getSession();

		Date d = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = simple.format(d);

		tabP = Outils.getProduit();
		tabPa = (ArrayList) session.getAttribute("tableau");
		a = (Acheteur) session.getAttribute("Acheteur");

		String nomP[] = new String[tabPa.size()];
		int Qp[] = new int[tabPa.size()];

		String nomP2[] = new String[tabPa.size()];

		for (int i = 0; i < tabPa.size(); i++) {
			nomP[i] = tabPa.get(i).getNom();
			Qp[i] = tabPa.get(i).getQuantite();
		}

		for (int i = 0; i < nomP.length; i++) {

			nomP2[i] = Qp[i] + " " + nomP[i];

		}

		for (int i = 0; i < tabPa.size(); i++) {

			if (c == null) {
				for (Produit pr : tabP) {

					if (pr.getNom().equalsIgnoreCase(tabPa.get(i).getNom())) {
						pr.setQuantite(pr.getQuantite() - tabPa.get(i).getQuantite());
						try {
							pr.modifP();
							cv = new CommandeV(pr.getNom(), tabPa.get(i).getQuantite(),
									tabPa.get(i).getQuantite() * tabPa.get(i).getPrix(), a.getNom(), date);

							cv.Ajout();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				}
				c = new Commande(nomP2[i], a.getNom(), total, date);

			} else {

				for (Produit pr : tabP) {

					if (pr.getNom().equalsIgnoreCase(tabPa.get(i).getNom())) {
						pr.setQuantite(pr.getQuantite() - tabPa.get(i).getQuantite());
						try {
							pr.modifP();
							cv = new CommandeV(pr.getNom(), tabPa.get(i).getQuantite(),
									tabPa.get(i).getQuantite() * tabPa.get(i).getPrix(), a.getNom(), date);

							cv.Ajout();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						c.setNProduit(c.getNProduit() + "," + nomP2[i]);

					}
				}

			}

		}

		try {
			c.Ajout();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/Commande.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int total = Integer.parseInt(request.getParameter("total"));
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			con = Db.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session = request.getSession();

		Date d = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String date = simple.format(d);

		tabP = Outils.getProduit();

		a = (Acheteur) session.getAttribute("Acheteur");

		for (Produit pr : tabP) {

			if (pr.getP_id() == id) {
				pr.setQuantite(pr.getQuantite() - 1);
				try {
					pr.modifP();
					cv = new CommandeV(pr.getNom(), 1, total, a.getNom(), date);

					cv.Ajout();

					c = new Commande(pr.getNom(), a.getNom(), total, date);

					c.Ajout();

				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		}

		getServletContext().getRequestDispatcher("/Commande.jsp").forward(request, response);

	}

}
