<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logueo</title>
</head>
<body>

<form action="loginResult" method="post">

<table>
	<tr><th colspan="2"><h2>Logueo</h2></th></tr>
	<tr>
		<td>Código  : </td>
		<td><input type="text" placeholder="Juanchito" name="cod_cam"></td>
	</tr>
	<tr>
		<td>Contraseña  : </td>
		<td><input type="password" placeholder="P@ssword" name="pwd_cam"></td>
	</tr>
	<tr>
		<td><label><input type="checkbox" value="si" name="recordarme">&emsp;Recordarme&emsp;&emsp;</label></td>
		<td><input type="submit" value="Enviar"></td>
	</tr>
	
</table>
<input type="hidden" name="encriptado" value="false">
</form>
<a href="${pageContext.request.contextPath }/registro">No estoy registrado</a><br>
${msjLogueo }<br>
${sessionScope.camaradaLogueado.fec_ult_ing } ${sessionScope.camaradaLogueado.nom_cam } ${sessionScope.camaradaLogueado.ape_cam }
</body>
</html>