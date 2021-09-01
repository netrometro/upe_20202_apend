<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
<jsp:directive.page contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1" session="false" />
<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
		
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Apend</title>
		<link rel="icon" href="assets/educacao.png" />
		<link rel="stylesheet" href="assets/style.css" />
	</head>
	<body>
		<div class="container">
		  <header>
		  	<div class="branding">
		  		<div class="brand"><img src="assets/educacao.png" /></div>
		  		Apend
		  	</div>
		  	<div class="autentication">
				<form action="autentic" method="post">
					Usuário: <input name="user" type="text" /> 
					Senha: <input name="pass" type="password" /> 
					<input type="submit" value="Entrar"/>
				</form>
				<a href="autentic">Sair</a>
		  	</div>
		  </header>
		
		
		
			<h1>Append</h1> 
			<nave>
				<a href="/upe_20202_apend/aluno">Gerência de Aluno</a> | 
				<a href="#">Gerência de [Entidade]</a>
			</nave>
		</div>
	</body>
</html>

</jsp:root>