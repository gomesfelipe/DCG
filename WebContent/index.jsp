<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="model.*"%>
<%@ page import="java.util.List"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DCG</title>
</head>
<body>
<H1>
GRITE AQUI!
</H1>
<form action="comment" method="post">
	<input name="comment"><br/>
	<button type="submit">Comentar</button><br/>
</form>

<%
	HttpSession sessao = request.getSession();
	List<Comentario> all = (List<Comentario>) sessao.getAttribute("all");
%>

<%
	if(all!=null){
		for(Comentario comment:all){
%>

	<h1><% comment.getId(); %> GRITO: <% comment.getTexto(); %></h1></br>
	<h2>Data: <% comment.getRegistrationDate(); %></h2>
<%	
	}
	}else{
%>
	<h1>Não há nada!</h1>
<%	
	}
%>

</body>
</html>