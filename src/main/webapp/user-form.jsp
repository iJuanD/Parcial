<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Formulario Profesores</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
</head>
<body>
	<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-Danger justify-content-center nav-tabs">
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
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2 class="">
						<c:if test="${user != null}"> MODIFICANDO PROFESOR </c:if>
						
						<c:if test="${user == null}"> INGRESAR UN NUEVO PROFESOR </c:if>
					</h2>
					<br>
				</caption>
				<c:if test="${user != null}">
					<input type="hidden" name="id"
						value="<c:out
value='${user.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Nombre-Profesor:</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required" placeholder=" Manuel Medrano">
				</fieldset>
				<fieldset class="form-group">
					<label>Apellido-Profesor:</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control" required="required"
						name="email" placeholder=" Contreras Ortiz">
				</fieldset>
				<fieldset class="form-group">
					<label> Email:</label> <input type="text"
						value="<c:out value='${user.country}' />" class="form-control"
						name="country" required="required" placeholder=" manuel@gmail.com">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Fecha finalizacion-Contrato:</label> <input type="date"
						value="<c:out value='${user.fecha}' />" class="form-control" required="required"
						name="fecha" placeholder=" 27/05/22">
				</fieldset>
				
				
				<fieldset class="form-group">
					<label>Grupo Asignado de Tutor:</label> <input type="text"
						value="<c:out value='${user.celular}' />" class="form-control" required="required"
						name="celular" placeholder=" B194">
				</fieldset>
				<button type="submit" class="btn btn-outline-success my-2 my-sm-0 ">Enviar</button>
				<button type="reset" class="btn btn-outline-success my-2 my-sm-0 ">Limpiar Campos</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>