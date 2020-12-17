<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="js/bootstrap.min.js">
<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="js/bootstrap.bundle.min.js">
<link rel="stylesheet" href="js/alert.js">
</head>
<body>

<%
String usuario = (String)request.getSession().getAttribute("sUsuario");
if(usuario == null){
	response.sendRedirect("index.jsp");
}
%>

	<h1 aling="center">Administrar Direcciones</h1>
	<table>
		<tr>
			<td><a href="ServletCliente?action=inicio"
				class="btn btn-warning">Regresar al menu principal</a></td>
			<!--td><a href="ServletCliente?action=irNuevaDireccion">Registrar direccion</a></td-->
		</tr>
	</table>

	<table border="1" width="100%" class="table">
		<thead>
			<tr>
				<th scope="col">ID_DIRECCION</th>
				<th scope="col">CALLE</th>
				<th scope="col">NUMERO_EXTERIOR</th>
				<th scope="col">CODIO_POSTAL</th>
				<th scope="col">ESTADO</th>
				<th scope="col">REFERENCIA</th>
				<!--  td colspan=2>ACCIONES</td-->
			</tr>
		<thead>
		<tbody></tbody>
		<c:forEach items="${listaDir}" var="direccion">
			<tr>
				<td><c:out value="${direccion.idDireccion}" /></td>
				<td><c:out value="${direccion.calle}" /></td>
				<td><c:out value="${direccion.numeroExterior}" /></td>
				<td><c:out value="${direccion.codigoPostal}" /></td>
				<td><c:out value="${direccion.estado}" /></td>
				<td><c:out value="${direccion.referencia}" /></td>
				<!--td><a
					href="ServletCliente?action=editDireccion&idDireccion=<c:out value="${direccion.idDireccion}" />">Editar</a></td>
				<td><a
					href="ServletCliente?action=elimDireccion&idDireccion=<c:out value="${direccion.idDireccion}"/>">Eliminar</a>
				</td-->
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>