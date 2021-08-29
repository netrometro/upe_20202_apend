<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
  
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.upe.apend.model.entities.Aula"%>         
        
<% ArrayList<Aula> l = (ArrayList<Aula>) request.getAttribute("listagem"); %>
         
<!DOCTYPE html>
<html>
<head>
      <meta charset="ISO-8859-1">
      <title>Teste DAO aula</title>
</head>
<body>
<h1>DAO Aula :: Listar Todas</h1>

		<table border="1">
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Descricao</th>
				<th>IdCurso</th>
			</tr>
<% for (Aula au : l) { %>
			<tr>
				<td><%= au.getId() %></td>
				<td><%= au.getTitulo() %></td>
				<td><%= au.getDescricao() %></td>
				<td><%= au.getIdCurso() %></td>
			</tr>
<% } %>
		</table>

</body>
</html>