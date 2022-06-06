<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Formulario Estudiantes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
</head>
<body>
	<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-Info justify-content-center nav-tabs">
			<div class="text-center">
				 	 <img src="http://drive.google.com/uc?export=view&id=1QnEFt-x3hh0hTjPUdY2r1RiHgkYW4Nda" class="rounded img-fluid" width="100" alt="Profesores">
		</div>
			<div>
				<ul class="navbar-nav ">
					<li>
						<a href="user-list.jsp" class="navbar-brand nav-link "><strong>COLEGIO JUAN GABRIEL</strong></a>
					</li>
				</ul>
			</div>
			<ul class="navbar-nav">
				<!-- ESTUDIANTES -->
				<li><a href="<%=request.getContextPath()%>/listUser"
					class="nav-link"><strong>VER PROFESORES </strong></a></li>
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link"><strong>INGRESAR NUEVOS PROFESORES </strong></a></li>
					
					<!-- ESTUDIANTES -->
				<li><a href="<%=request.getContextPath()%>/listUser_estudiante"
					class="nav-link"><strong>VER ESTUDIANTES </strong></a></li>
				<li><a href="<%=request.getContextPath()%>/new_estudiante"
					class="nav-link"><strong>INGRESAR NUEVOS ESTUDIANTES </strong></a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update_estudiante" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert_estudiante" method="post">
				</c:if>
				<caption>
					<h2 class="">
						<c:if test="${user != null}">MODIFICANDO ESTUDIANTE</c:if>
						
						<c:if test="${user == null}"> INGRESAR UN NUEVO ESTUDIANTE </c:if>
					</h2>
					<br>
				</caption>
				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Nombre del estudiante:</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required" placeholder=" Daniel Andres">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Apellido del estudiante:</label> <input type="text"
						value="<c:out value='${user.apellido}' />" class="form-control"
						name="apellido" required="required" placeholder=" Rodriguez Cano">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Edad del estudiante:</label> <input type="text"
						value="<c:out value='${user.materia}' />" class="form-control"
						name="materia" required="required" placeholder=" 15 Años">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Grupo del estudiante:</label> <input type="text"
						value="<c:out value='${user.grupo}' />" class="form-control" required="required"
						name="grupo" placeholder=" B-193">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Año el cual esta Cursando:</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control" required="required"
						name="email" placeholder=" Noveno Grado">
				</fieldset>
				
				<button type="submit" class="btn btn-outline-success my-2 my-sm-0 ">Enviar</button>
				<button type="reset" class="btn btn-outline-success my-2 my-sm-0 ">Limpiar Campos</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>