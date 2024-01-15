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
				
				<br>
				<label for="idCliente"> Id Cliente</label> 
				<br>
				<input type="text" id="idCliente" name="id">
				<br>
				<label for="nombre"> Nombre</label>
				<br> 
				<input type="text" id="nombre" name="nombre"> 
				<br>
				<label for="correo">Correo Electronico</label> 
				<br>
				<input type="text" id="correo" name="correo">
				<br>	
				<label for="poblacion">Poblacion</label>
				 <br> 
				 
				 <select id="poblacion" name="poblacion" 
					form="formulario">
					<option value="" selected>--Seleccione una poblacion--</option>
					<c:forEach items="${comboPoblacion}" var="poblacion">
						<option value="${poblacion.id}">${poblacion.nombre}</option>
					</c:forEach>

					<option value="${cliente.idPoblacion}">${cliente.poblacion}</option>
					
				</select> 
				<br>
				<br> 
				<label for="activo"> Activo:</label>
				<br>
				<input type="checkbox" id="activo" name="activo">
				<br>
				<input type="submit" value="Enviar">
			</form>
		</div>
		
		
		
		
		<c:if test="${not empty lista}">
			<table>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>CorreoElectronico</th>
					<th>Poblacion</th>
					<th>Activo</th>
					


				</tr>
				<c:forEach items="${lista}" var="cliente">
					<tr>
						<td>${cliente.id_cliente}</td>
						<td>${cliente.nombre}</td>
						<td>${cliente.correo}</td>
						<td>${cliente.id_poblacion}</td>
						<td>${cliente.activo}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>