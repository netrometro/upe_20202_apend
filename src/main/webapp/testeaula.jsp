<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="br.upe.apend.model.entities.Aula"%>
	
	<%
	Aula au = (Aula) request.getAttribute("aula");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Teste entidade Aula</h1>

<p>Id: <%= au.getId() %></p>
<p>IdCurso: <%= au.getIdCurso() %></p>
<p>Titulo: <%= au.getTitulo() %></p>
<p>Descricao: <%= au.getDescricao() %></p>

<table border="1">
<% for (int i = 0; i < 10; i++) { %>
			<tr>
				<td><%= au.getId() %></td>
				<td><%= au.getIdCurso() %></td>
				<td><%= au.getTitulo() %></td>
				<td><%= au.getDescricao() %></td>
			</tr>
<% } %>	
		</table>
		
</body>
</html>