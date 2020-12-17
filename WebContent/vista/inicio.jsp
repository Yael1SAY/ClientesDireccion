<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<!--link rel="stylesheet" href="css/bootstrap.min.css"-->
<!--link rel="stylesheet" href="css/bootstrap.css"-->
<!--link rel="stylesheet" href="js/bootstrap.min.js"-->
<!--link rel="stylesheet" href="css/bootstrap-reboot.min.css"-->
<!--link rel="stylesheet" href="js/bootstrap.bundle.min.js"-->
<!--link rel="stylesheet" href="js/alert.js"-->
</head>
<body>


	<%
		String usuario = (String) request.getSession().getAttribute("sUsuario");
	if (usuario == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<h5>
		Bienvenido:
		<%=usuario%></h5>
		<br>
		<br>

	<div class="card-group" >
		<div class="card" align="center" style="width:60%;">
			<div class="card-body">
				<h5 class="card-title">ADMINISTRAR</h5>
			</div>
			<div class="card-footer">
				<a href="../ServletCliente?action=mostrarClienDir"
					class="btn btn-primary">ADMINISTRAR CLIENTES</a> <a
					href="../ServletCliente?action=mostrarDir" class="btn btn-primary">MOSTRAR
					DIRECCIONES</a>
			</div>
		</div>

		<div class="card" align="right" >
			<div class="card-body">
				<h5 class="card-title">CERRAR SESION</h5>
			</div>
			<div class="card-footer">
				<a href='../ServletLogin?conf=0' class='btn btn-warning'>LOGOUT</a>
			</div>
		</div>
	</div>

</body>
</html>