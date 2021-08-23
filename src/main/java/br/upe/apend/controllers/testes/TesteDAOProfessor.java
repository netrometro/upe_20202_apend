package br.upe.apend.controllers.testes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.apend.model.entities.Professor;
import br.upe.apend.model.persistency.DAOProfessor;

@WebServlet("/teste/dao/professor")
public class TesteDAOProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public TesteDAOProfessor() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProfessor daoProfessor= new DAOProfessor();
		
		ArrayList<Professor> lista = new ArrayList<>();
		
		try {
			lista = (ArrayList<Professor>) daoProfessor.listarTodos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listagem", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/testedaoaluno.jsp");
		rd.forward(request, response);
	}

}
