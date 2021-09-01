package br.upe.apend.model.persistency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import br.upe.apend.model.entities.Professor;

public class DAOProfessor {
	
	private Database db;
	
	public DAOProfessor() {
		db = new Database();
	}
	
	public List<Professor> listarTodos() throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM professor";
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Professor> lista= new ArrayList<>();
		
		while(rs.next()){
			Professor a = new Professor();
			
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

public void inserir(Professor professor) throws ClassNotFoundException, SQLException {
	Connection conn = db.getConnection();
	Statement stmt = conn.createStatement();
	
	String sql = "INSERT INTO professor (nome, email, senha, created_on) VALUES ("
	  + "'" + professor.getNome() + "', "
	  + "'" + professor.getEmail() + "', "
	  + "'" + professor.getSenha() + "',"
	  + "now()"
	  + ");";
    stmt.executeUpdate(sql);
    
	stmt.close();
	conn.close();		
}

}
