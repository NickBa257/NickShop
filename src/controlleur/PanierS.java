package controlleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Outils;
import modele.Panier;
import modele.Produit;

@WebServlet("/PanierS")
public class PanierS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Panier Pa = new Panier();

	ArrayList<Panier> tabPa;

	ArrayList<Produit> tabP;

	HttpSession session;

	boolean Check, fois;

	public PanierS() {

		tabP = Outils.getProduit();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		session = request.getSession();
		tabPa = (ArrayList)session.getAttribute("tableau");

		String action = request.getParameter("action");
		int i = Integer.parseInt(request.getParameter("id"));

		switch (action) {

		case "plus":

			for (int j = 0; j < tabPa.size(); j++) {

				if (tabPa.get(j).getP_id() == i) {

					for (Produit pr : tabP) {

						if (tabPa.get(j).getQuantite() < pr.getQuantite()
								&& tabPa.get(j).getNom().equals(pr.getNom())) {

							tabPa.get(j).setQuantite(tabPa.get(j).getQuantite() + 1);

							session.setAttribute("tableau", tabPa);

							getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);

						} else if (tabPa.get(j).getQuantite() == pr.getQuantite()
								&& tabPa.get(j).getNom().equals(pr.getNom())) {

							getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);

						}

					}

				}

			}

			getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);

			break;

		case "moins":

			for (int j = 0; j < tabPa.size(); j++) {

				if (tabPa.get(j).getP_id() == i && tabPa.get(j).getQuantite() > 1) {

					tabPa.get(j).setQuantite(tabPa.get(j).getQuantite() - 1);

					session.setAttribute("tableau", tabPa);

					getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);
				}

			}

			getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);

			break;

		case "retirer":

			for (int j = 0; j < tabPa.size(); j++) {

				if (tabPa.get(j).getP_id() == i) {

					tabPa.remove(j);
					session.setAttribute("tableau", tabPa);

					getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);
				}

			}

			getServletContext().getRequestDispatcher("/Panier.jsp").forward(request, response);

			break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int i = Integer.parseInt(request.getParameter("id"));
		Check = false;
		fois = false;

		session = request.getSession();

		if (session.getAttribute("tableau") == null) {

			tabPa = new ArrayList<>();

			for (Produit pr : tabP) {

				if (i == pr.getP_id()) {

					Pa = new Panier(pr.getP_id(), pr.getNom(), 1, pr.getPrix());

					tabPa.add(Pa);
				}
			}

			session.setAttribute("tableau", tabPa);

			getServletContext().getRequestDispatcher("/AccueilA.jsp").forward(request, response);

		} else {

			tabPa = (ArrayList) session.getAttribute("tableau");

			for (Panier p : tabPa) {

				if (i == p.getP_id()) {

					for (Produit pr : tabP) {

						if (p.getQuantite() < pr.getQuantite() && fois == false) {

							p.setQuantite(p.getQuantite() + 1);
							
							fois= true;

						} else {

							
						}

					}

					Check = true;
				}

			}

			if (Check == false) {

				for (Produit pr : tabP) {

					if (i == pr.getP_id()) {

						Pa = new Panier(pr.getP_id(), pr.getNom(), 1, pr.getPrix());

						tabPa.add(Pa);
					}

				}
			} else {

			}

			session.setAttribute("tableau", tabPa);

			getServletContext().getRequestDispatcher("/AccueilA.jsp").forward(request, response);

		}

	}

}
