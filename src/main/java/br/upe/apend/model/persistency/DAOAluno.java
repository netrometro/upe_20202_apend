package br.upe.apend.model.persistency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.upe.apend.model.entities.Aluno;

public class DAOAluno {
	
	private Database db;
	
	public DAOAluno() {
		db = new Database();
	}
	
	public List<Aluno> listarTodos() throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM aluno";
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Aluno> lista= new ArrayList<>();
		
		while(rs.next()){
			Aluno a = new Aluno();
			
			int id = rs.getInt("id");
			a.setId(id);
			a.setNome(rs.getString("nome"));
			a.setEmail(rs.getString("email"));
			a.setDataCriacao(rs.getDate("created_on"));
			
			lista.add(a);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return lista;
	}

	public void inserir(Aluno aluno) throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "INSERT INTO aluno (nome, email, senha, created_on) VALUES ("
		  + "'" + aluno.getNome() + "', "
		  + "'" + aluno.getEmail() + "', "
		  + "'" + aluno.getSenha() + "',"
		  + "now()"
		  + ");";
        stmt.executeUpdate(sql);
        
		stmt.close();
		conn.close();		
	}
	
}
