package br.upe.apend.model.persistency;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InstallProfessor {

	private Database db;

	public InstallProfessor() {
		db = new Database();
	}

	public void install() throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement stmt = conn.createStatement();

		String sql;

		sql = "DROP TABLE IF EXISTS professor;";
		stmt.executeUpdate(sql);
		System.out.println("Tabela PROFESSOr apagada...");

		sql = "CREATE TABLE professor(";
		sql += "id SERIAL NOT NULL PRIMARY KEY,";
		sql += "nome VARCHAR(100),";
		sql += "email VARCHAR(255),";
		sql += "senha VARCHAR(100),";
		sql += "created_on TIMESTAMP NOT NULL";
		sql += ");";

		stmt.executeUpdate(sql);
		System.out.println("Tabela PROFESSOR criada...");

		stmt.close();
		conn.close();
	}

	public void populate() throws ClassNotFoundException, SQLException {
		Connection conn = db.getConnection();
		Statement sttm = conn.createStatement();

		String sql;

		sql = "INSERT INTO prpfessor (nome, email, senha, created_on) VALUES ('Fulano de Tal', 'fulano@email.com', '111', now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO professor (nome, email, senha, created_on) VALUES ('Beltrano de Tal', 'beltrano@email.com', '222', now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO professor (nome, email, senha, created_on) VALUES ('Cicrano de Tal', 'cicrano@email.com', '333', now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO professor (nome, email, senha, created_on) VALUES ('y', 'y@email.com', '1', now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO professor (nome, email, senha, created_on) VALUES ('x', 'x@email.com', '2', now())";
		sttm.executeUpdate(sql);
		sql = "INSERT INTO professor (nome, email, senha, created_on) VALUES ('Fulano Tal de Tal e Tal Tal Tal', 'fulanotal@email.com', '000', now())";
		sttm.executeUpdate(sql);

		System.out.println("Tabela PROFESSOR populada...");

		sttm.close();
		conn.close();
	}
}
