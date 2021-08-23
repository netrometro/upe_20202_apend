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

import br.upe.apend.model.entities.Aluno;
import br.upe.apend.model.persistency.DAOAluno;

@WebServlet("/aluno")
public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlunoController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/aluno.jsp");
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
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setSenha(senha);
		
		DAOAluno daoAluno = new DAOAluno();
		
		try {
			daoAluno.inserir(aluno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		this.doGet(request, response);
	}

}
