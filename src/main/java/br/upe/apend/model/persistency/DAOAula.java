package br.upe.apend.model.persistency;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.upe.apend.model.entities.Aluno;
import br.upe.apend.model.entities.Aula;

public class DAOAula {

private Database db;
	
	public DAOAula() {
		db = new Database();
	}
	
	public List<Aula> listarTodos() throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM aula";
		ResultSet rs = stmt.executeQuery(sql);
		
		ArrayList<Aula> lista= new ArrayList<>();
		
		while(rs.next()){
			Aula aa = new Aula();
			
			int id = rs.getInt("id");
			aa.setId(id);
			aa.setTitulo(rs.getString("titulo"));
			aa.setDescricao(rs.getString("descricao"));
			aa.setIdCurso(rs.getInt("idCurso"));
			
			lista.add(aa);
		}
		rs.close();
		stmt.close();
		conn.close();
		
		return lista;
	
}
	
	public void inserir(Aula aula) throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql = "INSERT INTO aluno (titulo, descricao, idCurso, created_on) VALUES ("
		  + "'" + aula.getTitulo() + "', "
		  + "'" + aula.getDescricao() + "', "
		  + "'" + aula.getIdCurso() + "',"
		  + "now()"
		  + ");";
        stmt.executeUpdate(sql);
        
		stmt.close();
		conn.close();		
	}
}
