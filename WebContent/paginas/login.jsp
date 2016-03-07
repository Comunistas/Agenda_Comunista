<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logueo</title>

<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/bootstrap.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/estilo_general.css" />" rel="stylesheet" />
<link href="<c:url value="/recursos/css/jquery-ui.css" />" rel="stylesheet" />
<script src='<c:url value="/recursos/js/jquery-2.1.1.min.js" />'></script>
<script src='<c:url value="/recursos/js/bootstrap.min.js" />'></script>

</head>
<body>
<div class="todo">

	<div class="encabezado">
	<div><a class="alogo" href="login"><label class="logo"></label><br><h2>Agenda Comunista</h2></a></div>
	<br>
	</div>

	<div class="container contenido">
		
		<form action="loginResult" method="post">
		<center><h2>Logueo</h2></center>
			<div class="form-group input-group col-lg-6 col-md-8 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2">
				<span class="input-group-addon" style="width:30%">Código</span>
				<input class="form-control" type="text" placeholder="Juanchito" name="cod_cam">
			</div>
			
			<div class="form-group input-group col-lg-6 col-md-8 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2">
				<span class="input-group-addon" style="width:30%">Contraseña </span>
				<input class="form-control" type="password" placeholder="P@ssword" name="pwd_cam">
			</div>
			
			<div class="form-group input-group col-lg-6 col-md-8 col-sm-12 col-xs-12 col-lg-offset-3 col-md-offset-2">
				<label class="input-group-addon" style="width:30%"><input type="checkbox" value="si" name="recordarme">&emsp;Recordarme</label>
				<input class = "form-control btn btn-default" type="submit" value="Enviar">
			</div>
			
			<a class="col-lg-offset-3 col-md-offset-2" href="${pageContext.request.contextPath }/registro">No estoy registrado</a>
			<center><h4>${msjLogueo }</h4></center>
			<input type="hidden" name="encriptado" value="false">
		</form>
		
		
	
	</div> <!-- CONTENIDO -->
</div> <!-- TODO -->

</body>
</html>