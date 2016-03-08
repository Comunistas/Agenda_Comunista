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


<div class="todo">

	<%@include file="encabezado.jsp" %>
	
	<div class="contanier contenido">
		<form action="asociarse.accion" method="post">
		
		<center><h2>Asociarse a nuevo proyecto</h2></center>
		<div class="input-group col-lg-8 col-md-10 col-sm-12 col-xs-12 col-lg-offset-2 col-md-offset-1">
		
			<label class="input-group-addon">Llave</label>
			<input class="form-control" type="text" name="llave">
			<span class="input-group-btn">
				<button class="btn btn-default">Asociarse</button>
			</span>
		</div>
		
		</form>
	</div>
</div>
</body>
</html>