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

	<div align="center">
		<h1 align="center">Registrar Cliente</h1>
		<form action="ServletController?action=registrar" method="post">
			<table align="center">
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="txtNombre" required="true"
						class="form-control" maxlength="50" /></td>
				</tr>
				<tr>
					<td>Nombre:</td>
					<td><input type="text" name="txtApellido" required="true"
						class="form-control" maxlength="50" /></td>
				</tr>
				<tr>
					<td>Contrasenia:</td>
					<td><input type="password" name="txtContrasenia"
						required="true" class="form-control" maxlength="20" /></td>
				</tr>
				<tr>
					<td>Calle:</td>
					<td><input type="text" name="txtCalle" required="true"
						class="form-control" maxlength="50" /></td>
				</tr>
				<tr>
					<td>Numero Exterior:</td>
					<td><input type="text" name="txtNoExterior" required="true"
						class="form-control" maxlength="5" /></td>
				</tr>
				<tr>
					<td>Codigo Postal:</td>
					<td><input type="number" name="txtCodPostal" required="true"
						class="form-control" maxlength="6" /></td>
				</tr>
				<tr>
					<td>Estado:</td>
					<td><input type="text" name="txtEstado" required="true"
						class="form-control" maxlength="30" /></td>
				</tr>
				<tr>
					<td>Referencia:</td>
					<td><input type="text" name="txtReferencia" required="true"
						class="form-control" maxlength="250" /></td>
				</tr>

			</table>
			<br>
			<table border="0" align="center">
				<tr>
					<td><input type="submit" value="Agregar" name="agregar"
						class="btn btn-primary" onclick="pulsar()"></td>
					<td><a href="ServletCliente?action=inicio"
						class="btn btn-warning">Cancelar</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<h4 align="center">Lista Direcciones</h4>
		<table class="table" width="100%">
			<thead>
				<tr>
					<th scope="col">ID_DIRECCION</th>
					<th scope="col">CALLE</th>
					<th scope="col">NUMERO_EXTERIOR</th>
					<th scope="col">CODIO_POSTAL</th>
					<th scope="col">ESTADO</th>
					<th scope="col">REFERENCIA</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaDir}" var="direccion">
					<tr>
						<td><c:out value="${direccion.idDireccion}" /></td>
						<td><c:out value="${direccion.calle}" /></td>
						<td><c:out value="${direccion.numeroExterior}" /></td>
						<td><c:out value="${direccion.codigoPostal}" /></td>
						<td><c:out value="${direccion.estado}" /></td>
						<td><c:out value="${direccion.referencia}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
<%
		String msgAgre = (String) request.getSession().getAttribute("msgAgre");
	%>
	<script type="text/javascript">
		function pulsar() {
			alert('<%=msgAgre%>');
		}
	</script>
</body>
</html>