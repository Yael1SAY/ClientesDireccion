<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		String msg = (String) session.getAttribute("msg");
	if (msg == null || msg.isEmpty()) {
		out.print("");
	} else {
	%>
	<div class="alert alert-danger alert-dismissible fade show"
		role="alert">
		<strong><%out.append(msg);%></strong>
		<button type="button" class="close" data-dismiss="alert"
			aria-label="close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<%
		}
	%>
	<div class="card-group">
		<div class="card"></div>
		<div class="card" style="width: 22rem;" align="center">
			<form action="ServletCliente" method="POST" class="form-signin">
				<h1 class="h3 mb-3 font-weight-normal" align="center">Iniciar
					Sesion</h1>
				<img class="mb-4" src="img/user.png" width="190" height="190">
				<label for="usuario" class="sr-only">Email address</label> <input
					type="text" name="txtNombre" class="form-control"
					placeholder="Usuario" required> <label for="inputPassword"
					class="sr-only">Contraseña</label> <input type="password"
					name="txtContrasenia" class="form-control" placeholder="Password"
					required>
				<div class="checkbox mb-3" align="left">
					<label> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-primary btn-lg" type="submit">Sign
					in</button>
			</form>
		</div>
		<div class="card"></div>
	</div>
	<!--  
	<table align="center">
		<tr>
			<td>
			<td>
			<td border="1" align="center">
				<div align="center">
					<h1>Inicio de sesion</h1>
					<br>
					<form action="ServletCliente" method="POST">
						<table style="with: 100%">
							<tr>
								
								<td><input type="text" name="txtNombre" class="form-control"
									placeholder="User" required="true" /></td>
							</tr>
							<tr></tr>
							<tr>
								
								<td><input type="password" name="txtContrasenia" class="form-control"
									placeholder="Password" required="true" /></td>
							</tr>

						</table>
						<br> <br> <input type="submit" value="Acceder" class="btn btn-primary"/>
					</form>
				</div>
			</td>
			<td>
			<td>
		</tr>
	</table>
	-->
</body>
</html>