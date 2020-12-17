<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String usuario = (String)request.getSession().getAttribute("sUsuario");
if(usuario == null){
	response.sendRedirect("index.jsp");
}
%>

	<div align="center">
		<h1>Registrar Direccion</h1>
		<form action="ServletCliente?action=nuevaDireccion" method="post">
			<table border="1" align="center">
				<tr>
					<td>Calle:</td>
					<td><input type="text" name="txtCalle" /></td>
				</tr>
				<tr>
					<td>Numero Exterior:</td>
					<td><input type="text" name="txtNumeroExterior" /></td>
				</tr>
				<tr>
					<td>Codigo Postal:</td>
					<td><input type="text" name="txtCodigoPostal" /></td>
				</tr>
				<tr>
					<td>Estado:</td>
					<td><input type="text" name="txtEstado" /></td>
				</tr>
				<tr>
					<td>Referencia:</td>
					<td><input type="text" name="txtReferencia" /></td>
				</tr>

			</table>
			<br>
			<table border="0" align="center">
				<tr>
					<td><input type="submit" value="Agregar" name="agregar"></td>
				</tr>
			</table>
		</form>

		<td><a href="ServletCliente?action=inicio">Cancelar</a></td>

	</div>
</body>
</html>