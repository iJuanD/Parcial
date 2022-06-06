<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Listar Profesores</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
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
		</nav>	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success"
*ngIf='message'>{{message}}</div> -->
		
		<div class="container">
			<h3 class="text-center">LISTA DE PROFESORES GUARDADOS</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-outline-danger">INGRESAR NUEVO PROFESOR</a>
			</div>
			<br>
				<div class="text-center">
				 	 <img src="http://drive.google.com/uc?export=view&id=1bGVRYKMTdEklPLQx5Uy4djdpRUjhPlOF" class="rounded img-fluid" width="550" alt="Profesores">
				</div>
			<table class="table  table-hover border">
				<caption>Listado de Profesores Agregados en la Base de Datos</caption>
				<thead table-dark>
					<tr>
						<th>Codigo</th>
						<th>NOMBRE-PROFESOR</th>
						<th>APELLIDO-PROFESOR</th>
						<th>EMAIL-PROFESOR</th>
						<th>FINALIZACION DEL CONTRATO</th>
						<th>GRUPO AL QUE DICTA</th>
						<th>OPCIONES DEl ADMINISTRADOR</th>
					</tr>
				</thead>
				<tbody >
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="user" items="${listUser}">
						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.country}" /></td>
							<td><c:out value="${user.fecha}" /></td>
							<td><c:out value="${user.celular}" /></td>
							<td><a href="edit?id=<c:out
value='${user.id}' />">EDITAR</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out
value='${user.id}' />">ELIMINAR</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>