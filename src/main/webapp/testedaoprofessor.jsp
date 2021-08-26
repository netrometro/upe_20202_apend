<%@ page 
	language="java" 
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
	
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.upe.apend.model.entities.Professor"%>

<% ArrayList<Professor> l = (ArrayList<Professor>) request.getAttribute("listagem"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Teste DAO professor</title>
	</head>
	<body>
		<h1>DAO Professor :: Listar Todos</h1>
		
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Data da criação</th>
			</tr>
<% for (Professor p : l) { %>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getNome() %></td>
				<td><%= p.getEmail() %></td>
				<td><%= p.getDataCriacao().toString() %></td>
			</tr>
<% } %>
		</table>
		
	</body>
</html>