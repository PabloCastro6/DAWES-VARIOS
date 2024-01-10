<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
<title>Listado de Clientes</title>
</head>
<body>
	<header>
		<h2>Clientes</h2>
	</header>
	<%@include file="/menu.html"%>

	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/clientes/listarclientes"
				method="POST" id="formulario">
				<label for="IdCliente"> Id Cliente</label> <input type="text" id="idCliente"
					name="id">
				
				<label for="nombre"> Nombre</label> <input type="text" id="nombre"
					name="nombre"> 
					
				<label for="correoElectronico">
					Correo Electronico</label> <input type="text" id="correo" name="correo">
				<br>
				
					
					
				<label for="Poblacion">Poblacion</label> <br> 
				<select
					name="idpoblacion" id="poblacion" form="formulario">

					<br>


					<c:forEach items="${comboPoblacion}" var="poblacion">
						<option value="${poblacion.id}">${poblacion.nombre}</option>
					</c:forEach>

				</select> 
		
					
				<br><br> 
				<input type="submit" value="Buscar">
			</form>
		</div>
		
		<c:if test="${not empty lista}">
			<table>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>CorreoElectronico</th>
					<th>Contraseña</th>
					<th>FechaRegistro</th>
					<th>Id_Poblacion</th>
					<th>activo</th>
					


				</tr>
				<c:forEach items="${lista}" var="cliente">
					<tr>
						<td>${cliente.id}</td>
						<td>${cliente.nombre}</td>
						<td>${cliente.CorreoElectronico}</td>
						<td>${cliente.Contraseña}</td>
						<td>${cliente.FechaRegistro}</td>
						<td>${cliente.Id_Poblacion}</td>
						<td>${cliente.activo}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>