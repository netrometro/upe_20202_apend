package br.upe.apend.controllers.testes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.apend.model.entities.Aula;


@WebServlet("/teste/aula")
public class TesteAula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TesteAula() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aula au = new Aula ();
		
		au.setId(01);
		au.setDescricao("Aula da Universidade de Pernambuco, topicos integradores");
		au.setIdCurso(02);
		au.setTitulo("Tópicos Integradores");
		
		System.out.println(au.getId());
		System.out.println(au.getIdCurso());
		System.out.println(au.getTitulo());
		System.out.println(au.getDescricao());
		
		/*
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h1>Teste Entidade Aula</h1>");
		out.println("<p>" + au.getId() + "</p>");
		out.println("<p>" + au.getIdCurso() + "</p>");
		out.println("<p>" + au.getTitulo() + "</p>");
		out.println("<p>" + au.getDescricao() + "</p>");
		out.println("</body></html>");
		out.flush();
		*/
		
		request.setAttribute("aula", au);
		
		request.getRequestDispatcher("/testeaula.jsp").forward(request, response);
		
	}

}
