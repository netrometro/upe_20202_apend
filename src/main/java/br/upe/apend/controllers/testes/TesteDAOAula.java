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

import br.upe.apend.model.entities.Aula;
import br.upe.apend.model.persistency.DAOAula;


@WebServlet("/teste/dao/aula")
public class TesteDAOAula extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public TesteDAOAula() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DAOAula daoAula = new DAOAula();

		ArrayList<Aula> lista = new ArrayList<>();

		try {
			lista = (ArrayList<Aula>) daoAula.listarTodos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listagem", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/testedaoaula.jsp");
		rd.forward(request, response);

	}

}
