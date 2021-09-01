package br.upe.apend.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.apend.model.persistency.DAOAluno;

@WebServlet("/alunoexcluir")
public class AlunoExcluirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlunoExcluirController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String id = request.getParameter("id");
	  
	  if (id != null) {
  	  DAOAluno daoAluno = new DAOAluno();
  	  
  	  try {
        daoAluno.excluir(Integer.parseInt(id));
      } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
        e.printStackTrace();
      }
	  }
	  
	  response.sendRedirect(request.getContextPath() + "/aluno");
	}

}
