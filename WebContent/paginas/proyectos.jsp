<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis Proyectos</title>
</head>
<body>

<table>
	<tr>
		<th colspan="4"><center>Mis Proyectos</center></th>
	</tr>
	
	<c:if test="${empty listaProyectosPorCamarada }">
		<tr><td colspan="4"><center>No est�s asociado a ning�n proyecto</center></td></tr>
	</c:if>
	
	<tr>
		<td>Fec. Inicio</td>
		<td>Nombre</td>
		<td>Perfil</td>
		<td>Llave</td>
	</tr>
	<c:forEach items="${listaProyectosPorCamarada }" var="pro">
		<tr class="${integrante[pro.value.cod_pro].coordinador == 1 ? 'active' : ''}">
			<td style="width:20%">${pro.value.fec_ini_pro }</td>
			<td style="width:30%">${pro.value.nom_pro }</td>
			<td style="width:20%">${integrante[pro.value.cod_pro].perfil.des_per }</td>
			<td style="width:30%">${pro.value.llave }</td>
		</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath }/paginas/nuevo_proyecto.jsp">Crear nuevo proyecto</a><br>
${msjCargarProyectos }<br>
${msjGrabarProyecto }<br>
${llave!=null ? 'Con esta llave tus amigos podr�n unirse al proyecto que has creado: ' : '' }${llave}
</body>
</html>