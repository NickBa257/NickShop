package controlleur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Db;
import modele.Outils;
import modele.Produit;
import modele.Vendeur;

@WebServlet("/AjoutPS")
public class AjoutPS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	Connection con = null;
	Produit P;
	Vendeur V;

	ArrayList<Produit> tabP;

	int id;
	String nomP, categorie, quantite, prix, image;

	String msg;

	public AjoutPS() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			con = Db.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String action = request.getParameter("action");

		id = Integer.parseInt(request.getParameter("id"));

		tabP = Outils.getProduit();

		switch (action) {

		case "modifier":

			nomP = request.getParameter("nomP");
			categorie = request.getParameter("categorie");
			quantite = request.getParameter("quantite");
			prix = request.getParameter("prix");
			image = request.getParameter("image");

			request.setAttribute("id", id);
			request.setAttribute("nomP", nomP);
			request.setAttribute("categorie", categorie);
			request.setAttribute("quantite", quantite);
			request.setAttribute("prix", prix);
			request.setAttribute("image", image);

			getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);

			break;

		case "supprimer":

			for (Produit p : tabP) {

				if (p.getP_id() == id) {

					try {
						p.SuppP();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);

				}
			}

			break;

		default:

			getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);

			break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			con = Db.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String action = request.getParameter("action");

		session = request.getSession();

		switch (action) {

		case "enregistrer":

			V = (Vendeur) session.getAttribute("Vendeur");

			P = new Produit(request.getParameter("nomP"), request.getParameter("categorie"),
					Integer.parseInt(request.getParameter("quantite")), Integer.parseInt(request.getParameter("prix")),
					request.getParameter("image"), V.getId());

			try {
				P.AjoutP();
				msg = "Enregistrement avec success";

				request.setAttribute("msg", msg);

			} catch (SQLException e) {
				msg = "Echec d'enregistrement";

				request.setAttribute("msg", msg);

			}

			getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);

			break;

		case "modifier":

			id = Integer.parseInt(request.getParameter("id"));

			tabP = Outils.getProduit();

			for (Produit p : tabP) {

				if (p.getP_id() == id && request.getParameter("image") != null) {

					p.setNom(request.getParameter("nomP"));
					p.setCategorie(request.getParameter("categorie"));
					p.setQuantite(Integer.parseInt(request.getParameter("quantite")));
					p.setPrix(Integer.parseInt(request.getParameter("prix")));
					p.setImage(request.getParameter("image"));

					try {
						p.modifP();
						msg = "Modificaton réussie";

						request.setAttribute("msg", msg);
					} catch (SQLException e) {
						msg = "Echec de Modificaton ";

						request.setAttribute("msg", msg);
					}

					getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);

				} else if (p.getP_id() == id && request.getParameter("image") == null) {

					p.setNom(request.getParameter("nomP"));
					p.setCategorie(request.getParameter("categorie"));
					p.setQuantite(Integer.parseInt(request.getParameter("quantite")));
					p.setPrix(Integer.parseInt(request.getParameter("prix")));

					try {
						p.modifP();
						msg = "Modificaton réussie";

						request.setAttribute("msg", msg);

					} catch (SQLException e) {
						msg = "Echec Modificaton ";

						request.setAttribute("msg", msg);

					}

					getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);

				}

			}

			getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);

			break;

		default:
			getServletContext().getRequestDispatcher("/AjoutP.jsp").forward(request, response);
			break;

		}

	}

}
