<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.upe.apend.model.entities.Aluno"%>
<%

Aluno a = (Aluno) request.getAttribute("aluno");

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Teste Entidade Aluno</h1>
		<p>Nome: <%= a.getNome() %></p>
		<p>E-mail: <%= a.getEmail() %></p>
		<p>Senha: <%= a.getSenha() %></p>	
		
		<table border="1">
<% for (int i = 0; i < 10; i++) { %>
			<tr>
				<td><%= a.getNome() %></td>
				<td><%= a.getEmail() %></td>
				<td><%= a.getSenha() %></td>
			</tr>
<% } %>	
		</table>
	</body>
</html>