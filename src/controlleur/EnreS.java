package controlleur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Db;
import modele.Acheteur;
import modele.Vendeur;

@WebServlet("/EnreS")
public class EnreS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Acheteur A;
	Vendeur V;
	Connection con = null;

	String msg;

	public EnreS() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String radio = request.getParameter("radio");
		try {
			con = Db.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (radio == null) {

			msg = "Dites si vous etes un vendeur ou un acheteur";

			request.setAttribute("msg", msg);

			getServletContext().getRequestDispatcher("/Enre.jsp").forward(request, response);

		} else if (radio.equals("Vendeur")) {
			V = new Vendeur(request.getParameter("nom"), request.getParameter("adresse"),
					Integer.parseInt(request.getParameter("tel")), request.getParameter("ident"),
					request.getParameter("pass"));

			try {
				V.AjoutV();
				msg = "Votre Compte a été bien crée";

				request.setAttribute("msg", msg);

			} catch (SQLException e1) {
				msg = "Echec de création du compte";

				request.setAttribute("msg", msg);

			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			getServletContext().getRequestDispatcher("/Enre.jsp").forward(request, response);

		} else if (radio.equals("Acheteur")) {

			A = new Acheteur(request.getParameter("nom"), request.getParameter("adresse"),
					Integer.parseInt(request.getParameter("tel")), request.getParameter("ident"),
					request.getParameter("pass"));

			try {
				A.AjoutA();
				msg = "Votre Compte a été bien crée";

				request.setAttribute("msg", msg);
			} catch (SQLException e1) {
				msg = "Echec de création du compte";

				request.setAttribute("msg", msg);
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			getServletContext().getRequestDispatcher("/Enre.jsp").forward(request, response);
		}

	}

}
