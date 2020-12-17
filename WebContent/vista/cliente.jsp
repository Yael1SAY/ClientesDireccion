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
		String usuario = (String) request.getSession().getAttribute("sUsuario");
	if (usuario == null) {
		response.sendRedirect("index.jsp");
	}
	%>

	<h1 align="center">Administrar Clientes</h1>
	<table border="0" width="100%">
		<tr>
			<td><a href="ServletCliente?action=irNuevoCliente"
				class="btn btn-primary">Nuevo Cliente</a></td>
			<td><a href="ServletCliente?action=inicio"
				class="btn btn-secondary">Ir al menú</a></td>
		</tr>
	</table>

	<table width="100%" class="table">
		<thead>
			<tr>
				<th scope="col">ID_CLIENTE</th>
				<th scope="col">USUARIO</th>
				<th scope="col">NOMBRE</th>
				<th scope="col">CONTRASENIA</th>
				<th scope="col">ID_DIRECCION</th>
				<th scope="col">CALLE</th>
				<th scope="col">No Exterior</th>
				<th scope="col">Codigo Postal</th>
				<th scope="col">ESTADO</th>
				<th scope="col">EFERENCIA</th>
				<th colspan=2 scope="col">ACCIONES</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaClientesDir}" var="cliente">

				<tr>
					<td scope="row"><c:out value="${cliente.idCliente}" /></td>
					<td scope="row"><c:out value="${cliente.nombre}" /></td>
					<td scope="row"><c:out value="${cliente.apellido}" /></td>
					<td scope="row"><c:out value="${cliente.contrasenia}" /></td>
					<td scope="row"><c:out value="${cliente.idDireccion}" /></td>
					<td scope="row"><c:out value="${cliente.calle}" /></td>
					<td scope="row"><c:out value="${cliente.numeroExterior}" /></td>
					<td scope="row"><c:out value="${cliente.codigoPostal}" /></td>
					<td scope="row"><c:out value="${cliente.estado}" /></td>
					<td scope="row"><c:out value="${cliente.referencia}" /></td>
					<td scope="row"><a class="btn btn-primary btn-sm"
						href="ServletCliente?action=mostrarEditCliente&id=<c:out value="${cliente.idCliente}" />">Editar</a></td>
					<td scope="row"><a class="btn btn-danger btn-sm"
						href="ServletCliente?action=mostrarElimCliente&id=<c:out value="${cliente.idCliente}"/>">Eliminar</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>