<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Camarada</title>
</head>
<body>

<form action="nuevoCamarada" method="post">
	<table>
		<tr><th colspan="2"><h2>Registro de Camarada</h2></th></tr>
		<tr>
			<td><label>C�digo de Cibertec: &emsp;</label></td>
			<td><input type="text" placeholder="i2014xxxxx" name="cod_cam"></td>
		</tr>
		<tr>
			<td><label>Nombre: </label></td>
			<td><input type="text" placeholder="Juanchito" name="nom_cam"></td>
		</tr>
		<tr>
			<td><label>Apellido: </label></td>
			<td><input type="text" placeholder="Alima�a" name="ape_cam"></td>
		</tr>
		<tr>
			<td><label>Tel�fono: </label></td>
			<td><input type="text" placeholder="666888777" name="tel_cam"></td>
		</tr>
		<tr>
			<td><label>Contrase�a: </label></td>
			<td><input type="password" placeholder="P@ssword" name="pwd_cam"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Enviar"></td>
		</tr>
	</table>
</form>

<a href="${pageContext.request.contextPath }/paginas/login.jsp">Regresar al login</a>

${msjRegistro }
</body>
</html>