<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="br.upe.apend.model.entities.Professor"%>

<% 
ArrayList<Professor> l = null;
if (request.getAttribute("listagem") != null) {
	l = (ArrayList<Professor>) request.getAttribute("listagem");
}
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>APEND :: Gerenciamento de Professor</title>
	</head>
	<body>
		<h1>Gerenciamento de Professor</h1>
		<hr>
		<h2>Inserir Professor</h2>
		<form method="post" action="professor">
			Nome: <input name="nome" type="text"><br>
			E-mail: <input name="email" type="text"><br>
			Senha: <input name="senha" type="password"><br>
			<input type="submit" value="Inserir professor">
		</form>
		<hr>
		
		<h2>Todos os professores</h2>
		
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Data da criação</th>
				<th>Excluir</th>
			</tr>
<% 
if (l != null) {
	for (Professor p : l) { %>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getNome() %></td>
				<td><%= p.getEmail() %></td>
				<td><%= p.getDataCriacao().toString() %></td>
				<td>
					<p href="professorexcluir?id=<%= p.getId() %>">Excluir</p>
				</td>
			</tr>
<% } } %>
		</table>
	</body>
</html>