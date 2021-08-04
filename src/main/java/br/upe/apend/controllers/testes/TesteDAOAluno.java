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

import br.upe.apend.model.entities.Aluno;
import br.upe.apend.model.persistency.DAOAluno;

@WebServlet("/teste/dao/aluno")
public class TesteDAOAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public TesteDAOAluno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOAluno daoAluno = new DAOAluno();
		
		ArrayList<Aluno> lista = new ArrayList<>();
		
		try {
			lista = (ArrayList<Aluno>) daoAluno.listarTodos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listagem", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/testedaoaluno.jsp");
		rd.forward(request, response);
	}

}
