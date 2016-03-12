<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Plantilla</title>


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
	
	<div class="contanier contenido">
		<h1>${msjError }</h1>
	</div>
</div>
</body>
</html>