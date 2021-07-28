package br.upe.apend.model.persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		//System.out.println(System.getenv("DATABASE_URL"));
		
		Class.forName("org.postgresql.Driver");
		Connection conn = (DriverManager.getConnection(System.getenv("DATABASE_URL")));
		
		return conn;
	}
}
