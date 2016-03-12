<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis Proyectos</title>

<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/estilo_general.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/jquery-ui.css" />" rel="stylesheet" />
<script src='<c:url value="/recursos/js/jquery-2.1.1.min.js" />'></script>
<script src='<c:url value="/recursos/js/jquery-ui.min.js" />'></script>

</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<div class="todo">

	<%@include file="encabezado.jsp" %>
	
	<div class="container contenido">
	
		<table class="table table-striped">
			<tr>
				<th colspan="4"><center>Mis Proyectos</center></th>
			</tr>
			
			<c:if test="${empty m.listaProyectos }">
				<tr><td colspan="4"><center>No estás asociado a ningún proyecto</center></td></tr>
			</c:if>
			
			<tr>
				<td>Fec. Inicio</td>
				<td>Nombre</td>
				<td>Perfil</td>
				<td>Llave</td>
			</tr>
			<c:forEach items="${m.listaProyectos }" var="proEntry">
				<c:set var="pro" value="${proEntry.value }"/>
				
				<tr class="${m.listaIntegrantesPorCamarada[pro.cod_pro].coordinador == 1 ? 'active' : ''}">
					<td style="width:20%">${pro.fec_ini_pro }</td>
					<td style="width:30%"><a href="${contextPath }/inicio?np=${pro.cod_pro}">${pro.nom_pro }</a></td>
					<td style="width:20%">${m.listaIntegrantesPorCamarada[pro.cod_pro].perfil.des_per }</td>
					<td style="width:30%"><a href="#${proEntry.value.cod_pro }">Ver</a></td>
				</tr>
				
			</c:forEach>
			<tr><td colspan="4"><center><a href="${contextPath }/nuevoProyecto">Crear nuevo proyecto</a></center></td></tr>
			<tr><td colspan="4"><center><a href="${contextPath }/asociarse">Asociarse a un proyecto</a></center></td></tr>
		</table>
		
		${msjCargarProyectos }<br>
		${msjAsociarseAProyecto}
		${msjGrabarProyecto }<br>
		${llave!=null ? 'Con esta llave tus amigos podrán unirse al proyecto que has creado: ' : '' }${llave}
	
	</div>

</div>

</body>
</html>