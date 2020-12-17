<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Direccion</title>
</head>
<body>

<%
String usuario = (String)request.getSession().getAttribute("sUsuario");
if(usuario == null){
	response.sendRedirect("index.jsp");
}
%>

</body>
</html>