<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="model.*"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Audiowide%7CRoboto+Condensed" rel="stylesheet">
<script src="script.js"></script>
<link rel="stylesheet" type="text/css" href="style.css">
<title>DCG</title>
</head>
<body>
	<h1>GRITE AQUI!</h1>
	<div class="mailbg">
	<form action="comment" method="post">
		<label class="l1" for="mailinput">Grite aqui:</label>
		<div class="result"></div>
		<textarea class="messtxt" name="comment" rows="4" cols="50" maxlength="140"></textarea>
		<button class="sendmess" type="submit">Comentar</button>
		<br />
	</form>
	</div>
	
<div class="container">
<ul>
<li>
<span></span>
	<%
		HttpSession sessao = request.getSession();
		List<Comentario> all = (List<Comentario>) sessao.getAttribute("all");
	%>

	<%
		if (all != null) {
			
			for (Comentario comment : all) {
	%>
	<%			if (comment.getId() == 1) {	%> <hr> <% }%>
	 			<span class="number"><span><h2> Data: <%=comment.getRegistrationDate()%></h2></span></span>
				<div class="info"><h3> ID: <%=comment.getId()%></h3>  <h1> GRITO: <%=comment.getTexto()%></h1></div>
				<form action="delete" method="post">
					<input name="id" value="<%= comment.getId()%>" style="display: none;">
					<button class="BTexcluir" type="submit">Excluir</button>
				</form>
				<hr>
	<%		}
		} else { %>
			<h1>Não há nada!</h1>
	<% } %>
  </li>
  </ul>
</div>
</body>
</html>