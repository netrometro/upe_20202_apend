package br.upe.apend.model.persistency;

import java.sql.SQLException;

public class Install {
	
	private InstallAluno ial;
	private InstallAula iau;
	// Crie o atributo de instalação de sua entidade aqui.
	
	public Install() {
		ial = new InstallAluno();
		iau = new InstallAula();
		// Instancie seu atributo aqui.
		
	}
	
	public void install() throws ClassNotFoundException, SQLException {
		ial.install();
		iau.install();
		// Invoque o método de instalação aqui.
		
	}
	
	public void populate() throws ClassNotFoundException, SQLException {
		ial.populate();
		iau.populate();
		// Invoque o método de popular aqui.
		
	}

}
