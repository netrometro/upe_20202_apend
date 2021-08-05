package br.upe.apend.controllers.testes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.apend.model.entities.Professor;

@WebServlet("/teste/professor")
public class TesteProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TesteProfessor() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Professor p = new Professor();
		p.setNome("Beltrano");
		p.setEmail("Beltrano@email.com");
		p.setSenha("40028922");

		System.out.println(p.getNome());
		System.out.println(p.getEmail());
		System.out.println(p.getSenha());
	
		request.setAttribute("professor", p);
		
		request.getRequestDispatcher("/testeprofessor.jsp").forward(request, response);
	}
	

}
