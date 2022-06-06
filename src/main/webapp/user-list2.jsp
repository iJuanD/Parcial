<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Listar Estudiantes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
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
				<li><a href="<%=request.getContextPath()%>/listUser"
					class="nav-link"><strong>VER PROFESORES </strong></a></li>
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link"><strong>INGRESAR NUEVOS PROFESORES </strong></a></li>
					
					<!-- ESTUDIANTES -->
				<li><a href="<%=request.getContextPath()%>/listUser_estudiante"
					class="nav-link"><strong>VER ESTUDIANTES </strong></a></li>
				<li><a href="<%=request.getContextPath()%>/new_estudiante"
					class="nav-link"><strong>INGRESAR ESTUDIANTES NUEVOS</strong></a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success"
*ngIf='message'>{{message}}</div> -->
		<div class="container">
			<h3 class="text-center">LISTA DE ESTUDIANTES INGRESADOS</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new_estudiante" class="btn btn-outline-primary">INGRESAR ESTUDIANTE NUEVO</a>
			</div>
			<br>
			<div class="text-center">
				 	 <img src="http://drive.google.com/uc?export=view&id=1hWwXP8PybnKkrl0xAI9VHWiafa_RcE2G" class="rounded mx-auto d-block " width="450" alt="Profesores">
				</div>
				<br>
			<table class="table table-dark table-hover">
				<caption>Listado de Estudiantes Agregados a la Base de Datos</caption>
				<thead >
					<tr>
						<th>Codigo</th>
						<th>NOMBRE-ESTUDIANTE</th>
						<th>APELLIDO-ESTUDIANTE</th>
						<th>EDAD</th>
						<th>GRUPO-ESTUDIANTE</th>
						<th>AÑO CURSANDO</th>
						<th>OPCIONES DEL ADMINISTRADOR</th>
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="user" items="${listUser}">
						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.apellido}" /></td>
							<td><c:out value="${user.materia}" /></td>
							<td><c:out value="${user.grupo}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><a href="edit_estudiante?id=<c:out value='${user.id}' />">EDITAR</a>
								 &nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete_estudiante?id=<c:out  value='${user.id}' />">ELIMINAR</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>