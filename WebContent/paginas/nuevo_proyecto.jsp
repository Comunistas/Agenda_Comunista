<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear un nuevo proyecto</title>

<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/estilo_general.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/jquery-ui.css" />" rel="stylesheet" />
<script src='<c:url value="/recursos/js/jquery-2.1.1.min.js" />'></script>
<script src='<c:url value="/recursos/js/jquery-ui.min.js" />'></script>

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

<div class="todo">

	<%@include file="encabezado.jsp" %>
	

	<div class="contenido">
	
		<form action="grabarNuevoProyecto" method="post">
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
					<td>Perfil</td>
					<td>
						<select name="perfil">
							<c:forEach items="${listaPerfiles }" var="x">
								<option value="${x.cod_per }">${x.des_per }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Grabar"></td>
				</tr>
			</table>
		</form>
		<a href="${pageContext.request.contextPath }/cargarProyectos"></a>
	
	</div>
</div>

</body>
</html>