<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Cliente</title>
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

	<form action="ServletController?action=editCliente" method="post">
		<h1 align="center">Editar Cliente</h1>
		<table align="center">
			<tr>
				<td><label>IdCliente</label></td>
				<td><input type="text" name="txtIdCliente" readonly
					required="true" class="form-control"
					value="<c:out value="${clienteDir.idCliente}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>Usuario</label></td>
				<td><input type="text" name="txtNombre" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.nombre}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="txtApellido" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.apellido}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Contrasenia</label></td>
				<td><input type="text" name="txtContrasenia" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.contrasenia}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>id Direccion</label></td>
				<td><input type="text" name="txtIdDireccion" readonly
					required="true" class="form-control"
					value='<c:out value="${clienteDir.idDireccion }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Calle</label></td>
				<td><input type="text" name="txtCalle" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.calle }"></c:out>'></td>
			</tr>

			<tr>
				<td><label>No Exterior</label></td>
				<td><input type="text" name="txtNoExterior" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.numeroExterior }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Codigo Postal</label></td>
				<td><input type="number" name="txtCodPostal" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.codigoPostal }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Estado</label></td>
				<td><input type="text" name="txtEstado" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.estado }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Referencia</label></td>
				<td><input type="text" name="txtReferencia" required="true"
					class="form-control"
					value='<c:out value="${clienteDir.referencia }"></c:out>'></td>
			</tr>
			<tr />
			<tr>
				<td><input type="submit" name="Actulizar" value="Actualizar"
					class="btn btn-primary" onclick="pulsar()"></td>
				<td><a href="ServletCliente?action=inicio"
					class="btn btn-warning">Regresar al menú</a></td>
			</tr>
		</table>
	</form>
<%
		String msgEdit = (String) request.getSession().getAttribute("msgEdit");
	%>
	<script type="text/javascript">
		function pulsar() {
			alert('<%=msgEdit%>');
		}
	</script>
</body>
</html>