<div class="encabezado">
	<div><a class="alogo" href="login"><label class="logo"></label><h2>Agenda Comunista</h2></a></div>
		<nav class="navbar navbar-default">
			<div class="navbar-header">
				<button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarr" aria-expanded="false"><span class="caret"></span></button> <!-- boton cuando colapsa -->
			</div>
			
			<div class="collapse navbar-collapse" id="navbarr">
				<ul class="nav navbar-nav">
				<li><a href="${contextPath }/inicio?np=${m.proyecto.cod_pro}">Inicio</a></li>
				<li><a href="${contextPath }/integrantes/todos?np=${m.proyecto.cod_pro}">Integrantes</a></li>
				<li><a>Actividades</a></li>
				<li><a>Reuniones</a></li>
				<li><a>Variables</a></li>
				<li><a>Estándares</a></li>
				<li><a>Estadísticas</a></li>
				<li><a>Proyectos</a></li>
				</ul>
			</div>
		</nav>
</div>

<script src='<c:url value="/recursos/js/bootstrap.min.js" />'></script>
