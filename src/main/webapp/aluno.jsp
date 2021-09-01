<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="br.upe.apend.model.entities.Aluno"%>

<% 
ArrayList<Aluno> l = null;
if (request.getAttribute("listagem") != null) {
	l = (ArrayList<Aluno>) request.getAttribute("listagem");
}
%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>APEND :: Gerenciamento de Aluno</title>
	</head>
	<body>
		<h1>Gerenciamento de Aluno</h1>
		<hr>
		<h2>Inserir Aluno</h2>
		<form method="post" action="aluno">
			Nome: <input name="nome" type="text"><br>
			E-mail: <input name="email" type="text"><br>
			Senha: <input name="senha" type="password"><br>
			<input type="submit" value="Inserir aluno">
		</form>
		<hr>
		
		<h2>Todos os alunos</h2>
		
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
	for (Aluno a : l) { %>
			<tr>
				<td><%= a.getId() %></td>
				<td><%= a.getNome() %></td>
				<td><%= a.getEmail() %></td>
				<td><%= a.getDataCriacao() %></td>
				<td>
					<a href="alunoexcluir?id=<%= a.getId() %>">Excluir</a>
				</td>
			</tr>
<% } } %>
		</table>
	</body>
</html>