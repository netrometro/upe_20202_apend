<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.upe.apend.model.entities.Aluno"%>

<% ArrayList<Aluno> l = (ArrayList<Aluno>) request.getAttribute("listagem"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Teste DAO aluno</title>
	</head>
	<body>
		<h1>DAO Aluno :: Listar Todos</h1>
		
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Data da criação</th>
			</tr>
<% for (Aluno a : l) { %>
			<tr>
				<td><%= a.getId() %></td>
				<td><%= a.getNome() %></td>
				<td><%= a.getEmail() %></td>
				<td><%= a.getDataCriacao() %></td>
			</tr>
<% } %>
		</table>
		
	</body>
</html>