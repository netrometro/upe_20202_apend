package br.upe.apend.model.p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection(System.getenv("DATABASE_URL"));
		
		return conn;
	}
	
}
