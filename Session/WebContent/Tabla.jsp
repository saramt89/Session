<%@page import="tiendaOnline.Producto"%>
<%@page import="tiendaOnline.AccesoBBDD"%>
<%@page import="tiendaOnline.CrearTabla"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
String usuario = (String)session.getAttribute("usuario");
ArrayList<Producto> lista = (ArrayList<Producto>)request.getAttribute("listaProductos");
String tabla = CrearTabla.fabricarTabla(lista);
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="mystyle.css">
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>PRODUCTOS</h2>
		<form action="MiServlet" method="post">
			<%=tabla %>
			<input type="image" src="https://image.flaticon.com/icons/png/512/107/107831.png" width="40px" height="40px">
			<input type="hidden" name="accion" value="comprar">
		</form>
		<a href="Indice.jsp">Volver</a>
	</body>
</html>