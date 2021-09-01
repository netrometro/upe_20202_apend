package br.upe.apend.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/autentic")
public class AutenticarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AutenticarController() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();

		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		
		System.out.println(pass + "   " + user);
		//if (user.equals("111") && pass.equals("111")) {
			// Autenticado
			System.out.println("ok");
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/segredo.jsp");
			rd.forward(request, response);
		//}
		
		// não foi autenticado
	}

}
