<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear un nuevo proyecto</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/css/jquery-ui.css">
<script src="${pageContext.request.contextPath }/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-ui.min.js"></script>

<script>
	$(function(){
		var hoy = new Date();
		$('.datepicker').datepicker({
			  dateFormat: "yy/mm/dd"
		}).datepicker("setDate", new Date());
		$( ".datepicker" ).datepicker( "option", "altFormat", "yy-mm-dd" );
	});
</script>
</head>
<body>

<form action="${pageContext.request.contextPath }/grabarNuevoProyecto" method="post">
	<table>
		<tr><th colspan="2">Nuevo proyecto</th></tr>
		<tr>
			<td>Nombre de proyecto</td>
			<td><input type="text" name="nom_pro" placeholder="ProyectoX"></td>
		</tr>
		<tr>
			<td>Fecha Inicio</td>
			<td><input type="text" name="fec_ini_pro" class="datepicker"></td>
		</tr>
		<tr>
			<td>Fecha Límite</td>
			<td><input type="text" name="fec_lim_pro" class="datepicker"></td>
		</tr>
		<tr>
			<td>Fecha Límite</td>
			<td><input type="text" name="fec_lim_pro" class="datepicker"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Grabar"></td>
		</tr>
	</table>
</form>
<a href="${pageContext.request.contextPath }/cargarProyectos"></a>
</body>
</html>