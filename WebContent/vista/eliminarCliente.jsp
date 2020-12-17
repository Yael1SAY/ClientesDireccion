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
	<!--  
	<form action="ServletController?action=elimCliente" method="post">
		<div class="mb-3">
			<label for="IdClinete" class="form-label">ID Cliente</label> 
			<input
				type="text" class="form-control" id="txtIdCliente" readonly
				value="<c:out value="${clienteDir.idCliente}"></c:out>">
			<div id="idCliente" class="form-text"></div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control"
				id="exampleInputPassword1">
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Check me
				out</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
-->


	<form action="ServletController?action=elimCliente" method="post">
		<h1 align="center">Editar Cliente</h1>
		<table align="center">
			<tr>
				<td><label class="form-label">IdCliente</label></td>
				<td><input type="text" name="txtIdCliente" readonly
					class="form-control" required="true"
					value="<c:out value="${clienteDir.idCliente}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>USUARIO</label></td>
				<td><input type="text" name="txtNombre" readonly
					class="form-control"
					value='<c:out value="${clienteDir.nombre}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>NOMBRE</label></td>
				<td><input type="text" name="txtApellido" readonly
					class="form-control"
					value='<c:out value="${clienteDir.apellido}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Contrasenia</label></td>
				<td><input type="text" name="txtContrasenia" readonly
					class="form-control"
					value='<c:out value="${clienteDir.contrasenia}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>id Direccion</label></td>
				<td><input type="text" name="txtIdDireccion" readonly
					class="form-control" required="true"
					value='<c:out value="${clienteDir.idDireccion }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Calle</label></td>
				<td><input type="text" name="txtCalle" readonly
					class="form-control"
					value='<c:out value="${clienteDir.calle }"></c:out>'></td>
			</tr>

			<tr>
				<td><label>No Exterior</label></td>
				<td><input type="text" name="txtNoExterior" readonly
					class="form-control"
					value='<c:out value="${clienteDir.numeroExterior }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Codigo Postal</label></td>
				<td><input type="number" name="txtCodPostal" readonly
					class="form-control"
					value='<c:out value="${clienteDir.codigoPostal }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Estado</label></td>
				<td><input type="text" name="txtEstado" readonly
					class="form-control"
					value='<c:out value="${clienteDir.estado }"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Referencia</label></td>
				<td><input type="text" name="txtReferencia" readonly
					class="form-control"
					value='<c:out value="${clienteDir.referencia }"></c:out>'></td>
			</tr>
			<tr>
				<td><input type="submit" name="eliminar" value="Eliminar"
					class="btn btn-danger" onclick="pulsar()"></td>
				<td><a href="ServletCliente?action=inicio"
					class="btn btn-warning">Regresar al menú</a></td>
			</tr>
		</table>
	</form>
<%
		String msgElim = (String) request.getSession().getAttribute("msgElim");
	%>
	<script type="text/javascript">
		function pulsar() {
			alert('<%=msgElim%>');
		}
	</script>

</body>
</html>