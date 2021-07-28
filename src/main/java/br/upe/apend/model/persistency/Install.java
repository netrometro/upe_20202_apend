package br.upe.apend.model.persistency;

import java.sql.SQLException;

public class Install {
	
	private InstallAluno ial;
	// Crie o atributo de instalação de sua entidade aqui.
	
	public Install() {
		ial = new InstallAluno();
		// Instancie seu atributo aqui.
		
	}
	
	public void install() throws ClassNotFoundException, SQLException {
		ial.install();
		// Invoque o método de instalação aqui.
		
	}
	
	public void populate() throws ClassNotFoundException, SQLException {
		ial.populate();
		// Invoque o método de popular aqui.
		
	}

}
