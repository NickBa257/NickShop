package controlleur;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.SQLException;

import modele.Acheteur;
import modele.Bloque;
import modele.Db;
import modele.Outils;
import modele.Vendeur;

@WebServlet("/LoginS")
public class LoginS extends HttpServlet {

	private static final long serialVersionUID = 1L;

	final int TENTATIVES_MAX = 5;
	final long TEMPS_MAX = 5 * 60 * 1000;
	Connection con;

	String msg, ip, date;

	int compt = 0;

	HttpSession session;

	Cookie cookie;

	Cookie[] TabCookie;

	SimpleDateFormat simple;

	Date d;

	Acheteur A;
	Vendeur V;
	Bloque b;

	ArrayList<Acheteur> tabA;
	ArrayList<Vendeur> tabV;
	ArrayList<Bloque> tabB;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			con = Db.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		ip = request.getRemoteAddr();

		tabA = Outils.getAcheteur();
		tabV = Outils.getVendeur();
		tabB = Outils.getBloque();

		A = null;
		V = null;

		TabCookie = request.getCookies();

		for (Cookie cookie1 : TabCookie) {

			if (cookie1.getName().equals("TpsB")) {

				System.out.println(0);

				getServletContext().getRequestDispatcher("/Bloque.jsp").forward(request, response);
				break;
			}
		}

		for (Acheteur a : tabA) {

			if (a.getIdent().equals(request.getParameter("ident"))
					&& a.getPass().equals(request.getParameter("pass"))) {

				A = a;

				session = request.getSession();

				session.setAttribute("Acheteur", A);

				getServletContext().getRequestDispatcher("/AccueilA.jsp").forward(request, response);
			
				break;
			}

		}
		for (Vendeur v : tabV) {

			if (v.getIdent().equals(request.getParameter("ident"))
					&& v.getPass().equals(request.getParameter("pass"))) {

				V = v;

				session = request.getSession();

				session.setAttribute("Vendeur", v);

				getServletContext().getRequestDispatcher("/AccueilV.jsp").forward(request, response);
				
				break;
			}

		}

		if ((V == null || A == null) && compt >= TENTATIVES_MAX) {

			System.out.println(1);

			boolean isBlocked = false;

			for (Bloque b1 : tabB) {
				if (b1.equals(ip)) {
					isBlocked = true;
					break;
				}
			}

			if (isBlocked == true) {
				for (Bloque b1 : tabB) {
					if (b1.equals(ip)) {

						d = new Date();
						simple = new SimpleDateFormat("dd/MM/YYYY HH:mm");
						date = simple.format(d);

						b1.setTentatives(b1.getTentatives() + 5);
						b1.setDate(date);

						b1.ModifB();

						cookie = new Cookie("TpsB", String.valueOf(TEMPS_MAX));
						cookie.setMaxAge((int) (TEMPS_MAX));

						response.addCookie(cookie);

						System.out.println(2);

						getServletContext().getRequestDispatcher("/Bloque.jsp").forward(request, response);
						break;
					}
				}
			} else {

				b = new Bloque(ip, compt);
				b.AjoutB();
				tabB.add(b);

				cookie = new Cookie("TpsB", String.valueOf(TEMPS_MAX));
				cookie.setMaxAge((int) (TEMPS_MAX));

				response.addCookie(cookie);

				System.out.println(3);

				getServletContext().getRequestDispatcher("/Bloque.jsp").forward(request, response);
			}
		} else if ((V == null || A == null) && compt < TENTATIVES_MAX - 1) {

			compt = compt + 1;

			msg = "Mot de passe incorrect ou vous n'avez pas de compte.Il vous reste " + (TENTATIVES_MAX - compt)
					+ " tentatives ";

			request.setAttribute("msg", msg);

			getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);

		}

	}
}
