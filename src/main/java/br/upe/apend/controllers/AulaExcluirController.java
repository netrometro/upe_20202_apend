package br.upe.apend.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.apend.model.persistency.DAOAula;


@WebServlet("/aulaexcluir")
public class AulaExcluirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AulaExcluirController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");
		 
		 if (id != null) {
		  	  DAOAula daoAula = new DAOAula();
		  	  
		  	  try {
		        daoAula.excluir(Integer.parseInt(id));
		      } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		      }
			  }
			  
			  response.sendRedirect(request.getContextPath() + "/aula");
			}
		 
	

}
