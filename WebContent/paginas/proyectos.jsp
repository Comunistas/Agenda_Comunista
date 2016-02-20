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
	
	<c:if test="${proyectos == null || proyectos.size==0 }">
		<tr><td colspan="4"><center>No estás asociado a ningún proyecto</center></td></tr>
	</c:if>
	
	<tr>
		<td>Fec. Inicio</td>
		<td>Nombre</td>
		<td>Perfil</td>
		<td>Llave</td>
	</tr>
	<c:forEach items="${proyectos }" var="pro">
		<tr class="${integrante[pro.cod_pro].coordinador == q ? 'active' : ''}">
			<td style="width:20%">${pro.fec_ini_pro }</td>
			<td style="width:30%">${pro.nom_pro }</td>
			<td style="width:20%">${integrante[pro.cod_pro].perfil.des_per }</td>
			<td style="width:30%">${pro.llave }</td>
		</tr>
	</c:forEach>
</table>
<a href="${pageContext.request.contextPath }/paginas/nuevo_proyecto.jsp">Crear nuevo proyecto</a><br>
${msjCargarProyectos }<br>
${msjGrabarProyecto }<br>
${llave!=null ? 'Con esta llave tus amigos podrán unirse al proyecto que has creado: ' : '' }${llave}
</body>
</html>