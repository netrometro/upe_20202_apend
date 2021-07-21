package br.upe.apend.controllers.testes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.upe.apend.model.Aluno;

@WebServlet("/teste/aluno")
public class TesteAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public TesteAluno() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno a = new Aluno();
		a.setNome("Fulano de Tal");
		a.setEmail("fulano@email.com");
		a.setSenha("111");
		
		System.out.println(a.getNome());
		System.out.println(a.getEmail());
		System.out.println(a.getSenha());
	}

}
