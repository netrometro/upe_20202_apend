<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
	     pageEncoding="ISO-8859-1"%>
	     
	<%@ page import="java.util.ArrayList" %>
<%@ page import="br.upe.apend.model.entities.Aula"%>     
	     
	 <% 
ArrayList<Aula> l = null;
if (request.getAttribute("listagem") != null) {
	l = (ArrayList<Aula>) request.getAttribute("listagem");
}
%> 
	  	     
<!DOCTYPE html>
<html>
     <head>
         <meta charset="ISO-8859-1">
         <title>APEND :: Gerenciamento de Aula</title>
</head>
<body>
<h1>Gerenciamento de Aula</h1>
<hr>
<h2>Inserir Aula</h2>
<form method="post" action="aula">
			Titulo: <input name="titulo" type="text"><br>
			Descricao: <input name="descricao" type="text"><br>
			IdCurso: <input name="idCurso" type="text"><br>
			<input type="submit" value="Inserir aula">
		</form>
		<hr>
		<h2>Todas as aulas</h2>
		
			<table border="1">
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Descricao</th>
				<th>IdCurso</th>
				<th>Excluir</th>
			</tr>
<% 
if (l != null) {
	for (Aula au : l) { %>
			<tr>
				<td><%= au.getId() %></td>
				<td><%= au.getTitulo() %></td>
				<td><%= au.getDescricao() %></td>
				<td><%= au.getIdCurso() %></td>
				<td>
				<a href="aulaexcluir?id=<%= au.getId() %>">Excluir</a>
				</td> 
			</tr>
<% } } %>
		</table>
		

</body>
</html>