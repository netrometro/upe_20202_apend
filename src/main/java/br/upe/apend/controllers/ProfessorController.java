package br.upe.apend.controllers;

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

@WebServlet("/professor")
public class ProfessorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfessorController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOProfessor daoProfessor = new DAOProfessor();
		
		ArrayList<Professor> lista = new ArrayList<>();
		
		try {
			lista = (ArrayList<Professor>) daoProfessor.listarTodos();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listagem", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/professor.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		/*
		PrintWriter out = response.getWriter();
		out.println("post");
		out.println(nome);
		out.println(email);
		out.println(senha);
		out.flush();
		*/
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setSenha(senha);
		
		DAOProfessor daoProfessor = new DAOProfessor();
		
		try {
			daoProfessor.inserir(professor);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		this.doGet(request, response);
	}

}
