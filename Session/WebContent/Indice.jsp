<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="MiServlet" method="post">
			<input type="text" name="usuario" placeholder="Usuario">
			<input type="password" name="password" placeholder="Contraseña">
			<input type="submit" value="Enviar">
			<input type="hidden" name="accion" value="entrar">
		</form>
	</body>
</html>