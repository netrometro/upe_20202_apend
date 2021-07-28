package br.upe.apend.controllers.testes;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.apend.model.persistency.Install;


@WebServlet("/teste/database")
public class TesteDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public TesteDatabase() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Install install = new Install();
		
		try {
			install.install();
			install.populate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
