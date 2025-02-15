package controlleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/DeconnectionS")
public class DeconnectionS extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	HttpSession session;
	
	
    public DeconnectionS() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session = request.getSession();
		
	    if(session!=null) {
	    	
	    	session.invalidate();
	    	
	    	getServletContext().getRequestDispatcher("/Login.jsp").forward(request,response);
	    }
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
