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

import br.upe.apend.model.entities.Aula;
import br.upe.apend.model.persistency.DAOAula;


@WebServlet("/aula")
public class AulaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AulaController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/aula.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String idCurso = request.getParameter("idCurso");
		/*
		PrintWriter out = response.getWriter();
		out.println("post");
		out.println(titulo);
		out.println(descricao);
		out.println(idCurso);
		out.flush();
		*/
		Aula aula = new Aula();
		aula.setTitulo(titulo);
		aula.setDescricao(descricao);
		aula.setIdCurso(Integer.parseInt(idCurso));
		
		DAOAula daoAula = new DAOAula();
		
		try {
			daoAula.inserir(aula);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		this.doGet(request, response);
		
	}

}
