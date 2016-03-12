<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Camarada</title>

<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/estilo_general.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/jquery-ui.css" />" rel="stylesheet" />
<script src='<c:url value="/recursos/js/jquery-2.1.1.min.js" />'></script>
<script src='<c:url value="/recursos/js/jquery-ui.min.js" />'></script>

</head>
<body>

<div class="todo">

	<div class="encabezado">
	<div><a class="alogo" href="login"><label class="logo"></label><br><h2>Agenda Comunista</h2></a></div>
	<br>
	</div>


	<div class="contenido">
		<form action="${pageContext.request.contextPath }/registro.accion" method="post">
			<table>
				<tr><th colspan="2"><h2>Registro de Camarada</h2></th></tr>
				<tr>
					<td><label>Código de Cibertec: &emsp;</label></td>
					<td><input type="text" placeholder="i2014xxxxx" name="cod_cam"></td>
				</tr>
				<tr>
					<td><label>Nombre: </label></td>
					<td><input type="text" placeholder="Juanchito" name="nom_cam"></td>
				</tr>
				<tr>
					<td><label>Apellido: </label></td>
					<td><input type="text" placeholder="Alimaña" name="ape_cam"></td>
				</tr>
				<tr>
					<td><label>Teléfono: </label></td>
					<td><input type="text" placeholder="666888777" name="tel_cam"></td>
				</tr>
				<tr>
					<td><label>Contraseña: </label></td>
					<td><input type="password" placeholder="P@ssword" name="pwd_cam"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Enviar"></td>
				</tr>
			</table>
		</form>
		
		<a href="${pageContext.request.contextPath }/login">Regresar al login</a>
		
		${msjRegistro }
	</div>

</div>


</body>
</html>