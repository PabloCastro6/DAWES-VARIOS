<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<%@ page isELIgnored="false"%>
<html>
<head>
<link rel="stylesheet" href="/tienda/css/index.css">
<link rel="stylesheet" href="/tienda/css/formularios.css">
<link rel="stylesheet" href="/tienda/css/tablas.css">
</head>
<body>
	<header>
		<h2>Panel de control Tienda de componentes infórmaticos</h2>
	</header>
	<%@include file="/menu.html"%>
<div class="container">
	<div class="form">
		<form action="http://localhost:8080/tienda/clientes/insertarclientes" method="POST" id="formulario">
			<label for="nombre"> Nombre</label>
						<br>
			<input type ="text" id="nombre" name="nombre">
						<br>
			<label for="correo">Correo Electronico</label>
						<br>
			<input type ="email" id="correo" name="correo" required>
			<br>
			
			<label for="poblacion">Poblacion:</label>
					  <br>
					<select name="idpoblacion"
					id="poblacion" form="formulario">


					<c:forEach items="${comboPoblacion}" var="poblacion">
						<option value="${poblacion.id}">${poblacion.nombre}</option>
					</c:forEach>

 					<option value="${cliente.idPoblacion}">${cliente.poblacion} </option>
				</select>
			<br>
			<label for="activo">Activo</label>
						<br>
			<input type="checkbox" id="activo" name="activo">
						<br>
			
			<input type ="submit" value="Enviar">
		</form>
	</div>

 <c:if test="${resultado == 1}">
 
 		<p> Cliente insertado correctamente </p>
 </c:if>
</div>
</body>
</html>