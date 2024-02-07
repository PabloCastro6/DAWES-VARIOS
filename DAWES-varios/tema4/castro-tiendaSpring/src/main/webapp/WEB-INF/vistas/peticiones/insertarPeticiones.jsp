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
<h2>Insertar Peticiones</h2>
</header>
<%@include file="../menu.html" %>
<body>
	
	<div class="container">
		<div class="form">
			<form action="http://localhost:8080/tienda/peticiones/insertarPeticiones" method="POST">
				<br>
				<label for="cliente">Cliente</label>
				
				
				<select name="idCliente" id="idCliente" form="formulario">
						<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				
				</select>
				
				
				<br> <br>
				
				<label for="producto">Productos</label> 
				<select name="idProducto" id="idProducto" form="formulario">
						<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboProducto}" var="producto">
						<option value="${producto.id}">${producto.nombre}</option>
					</c:forEach>
				
				</select>
				<br> <br>
				
				<label for="cantidad">Cantidad</label> 
				<input type="text" id="cantidad" name="cantidad" required> 
				<br><br>
				
				<label for="estadopedido">Estado Pedido</label> 
				<select name="estado" id="estado" form="formulario">
						<option value="">Seleccione una opcion</option>
						
					<c:forEach items="${comboEstadoPedido}" var="estadoPedido">
						<option value="${estadoPedido.id}">${estadoPedido.nombre}</option>
					</c:forEach>
				
				</select>
				<br>
				
				<input type="submit" value="Insertar">
			</form>
		</div>
		<c:if test ="${resultado == 1}">
		<p>Peticion insertada correctamente</p>
		</c:if>
	</div>


</body>
</html>