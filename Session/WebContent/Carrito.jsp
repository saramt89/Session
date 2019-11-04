<%@page import="tiendaOnline.Producto"%>
<%@page import="tiendaOnline.AccesoBBDD"%>
<%@page import="tiendaOnline.CrearTabla"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String usuario = (String)session.getAttribute("usuario");
ArrayList<Producto> lista=(ArrayList<Producto>)session.getAttribute("listaProductosComprados");
String tabla=CrearTabla.fabricarTablaSin(lista);
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="mystyle.css">
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>Usted ha comprado</h2>
		<%=tabla %>
		<form action="MiServlet" method="post">			
			<input type="submit" value="Seguir comprando">
			<input type="hidden" name="accion" value="volverTabla">
		</form>
		
	</body>
</html>