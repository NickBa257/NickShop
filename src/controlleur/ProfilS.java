package controlleur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Db;
import modele.Vendeur;
import modele.Acheteur;

@WebServlet("/ProfilS")
public class ProfilS extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Acheteur acheteur = null;
	Vendeur vendeur = null;
	HttpSession session;
	Connection con;

	public ProfilS() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			con = Db.getConnection();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		session = request.getSession();

		if (session.getAttribute("Acheteur") instanceof Acheteur) {
			
			acheteur = (Acheteur) session.getAttribute("Acheteur");

			acheteur.setNom(request.getParameter("nom"));
			acheteur.setAdresse(request.getParameter("adresse"));
			acheteur.setTel(Integer.parseInt(request.getParameter("tel")));
			acheteur.setIdent(request.getParameter("ident"));
			acheteur.setPass(request.getParameter("pass"));

			try {
				acheteur.ModifA();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("Acheteur", acheteur);

			getServletContext().getRequestDispatcher("/Profil.jsp").forward(request, response);

		} else if (session.getAttribute("Vendeur") instanceof Vendeur) {
			vendeur = (Vendeur) session.getAttribute("Vendeur");

			vendeur.setNom(request.getParameter("nom"));
			vendeur.setAdresse(request.getParameter("adresse"));
			vendeur.setTel(Integer.parseInt(request.getParameter("tel")));
			vendeur.setIdent(request.getParameter("ident"));
			vendeur.setPass(request.getParameter("pass"));

			try {
				vendeur.ModifV();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("Vendeur", vendeur);

			getServletContext().getRequestDispatcher("/Profil.jsp").forward(request, response);

		}
		
		getServletContext().getRequestDispatcher("/Profil.jsp").forward(request, response);


		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
