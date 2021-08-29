package br.upe.apend.model.persistency;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InstallAula {

	private Database db;
	
	public InstallAula() {
		db = new Database();
	}
	
	public void install() throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();

		String sql;

		sql = "DROP TABLE IF EXISTS aluno;";
		stmt.executeUpdate(sql);
		System.out.println("Tabela AULA apagada...");

		sql = "CREATE TABLE aula(";
		sql += "id SERIAL NOT NULL PRIMARY KEY,";
		sql += "titulo VARCHAR(100),";
		sql += "descricao VARCHAR(400),";
		sql += "idCurso INTEGER ,";
		sql += "created_on TIMESTAMP NOT NULL";
		sql += ");";

		stmt.executeUpdate(sql);
		System.out.println("Tabela AULA criada...");

		stmt.close();
		conn.close();
	}
	
	public void populate() throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement sttm = conn.createStatement();

		String sql;

		sql = "INSERT INTO aula (titulo, descricao, idCurso, created_on) VALUES ('Aula 1', 'Banco de dados', 01, now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO aula (titulo, descricao, idCurso, created_on) VALUES ('Aula 2', 'Programação 1', 02, now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO aula (titulo, descricao, idCurso, created_on) VALUES ('Aula 3', 'Programação 2', 03, now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO aula (titulo, descricao, idCurso, created_on) VALUES ('Aula 4', 'Programação 3', 04, now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO aula (titulo, descricao, idCurso, created_on) VALUES ('Aula 5', 'Topicos integradores', 05, now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO aula (titulo, descricao, idCurso, created_on) VALUES ('Aula 6', 'Upe 2022', 06, now())";
		sttm.executeUpdate(sql);

		System.out.println("Tabela AULA populada...");

		sttm.close();
		conn.close();
	}
	
	
	
	
}
