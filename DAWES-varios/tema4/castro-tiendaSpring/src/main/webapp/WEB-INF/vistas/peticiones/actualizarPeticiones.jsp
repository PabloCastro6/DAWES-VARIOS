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
<h2>Actualizar Peticiones</h2>
</header>
<%@include file="../menu.html" %>

<body>

<div class="container">
	
		<div class="form">
			<form action="http://localhost:8080/tienda/peticiones/formularioactualizarpeticiones"  method="POST">
				<label for="id">ID</label>
				<input type="text" id="id" name="idPeticiones"> 
				<br>
				
				<label for="cliente">Cliente</label>
				<select name="idCliente" id="cliente">
					<option value="" selected>-- Seleccione un cliente</option>
					<c:forEach items="${comboCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				</select> 
				<br> <br>
				
				<label for="producto">Productos</label> 
				<select name="idProducto" id="producto">
					<option value="" selected>-- Seleccione un producto</option>
					<c:forEach items="${comboProducto}" var="producto">
						<option value="${producto.id}">${producto.nombre}</option>
					</c:forEach>
				</select> 
				<br> <br>
				
				<label for="cantidad">Cantidad</label> <input type="text" id="cantidad" name="cantidad"> 
				<br> <br>
				
				<label for="estadopedido">Estado Pedido</label> 
				<select name="estado" id="proveedor">
					<option value="" selected>-- Seleccione un estado</option>
					<c:forEach items="${comboEstadoPedido}" var="estadopedido">
						<option value="${estadopedido.id}">${estadopedido.nombre}</option>
					</c:forEach>
				</select> 
				<br> <br>
				
				<label for="fecha">Fecha desde:</label>
				<input type="date" name="fecha" id="fecha">
				
				<br>
				
				<input type="submit" value="Buscar">
			</form>
		</div>
		
		<c:forEach items="${lista}" var="peticion">
		 	<div class="form">
		 		<form action="http://localhost:8080/tienda/peticiones/actualizarpeticiones" method="POST">
		 		
		 		<label for="id">ID</label> 
		 		<input type="text" id="id" name="idPeticiones" value="${peticion.id}" readonly> 
		 		<br>
		 		
				<label for="cliente">Cliente</label>
				<select name="idCliente" id="cliente">					
					<option value="${peticion.idCliente}" selected>${peticion.nombreCliente}</option>
					<c:forEach items="${comboCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				</select> 
				<br> <br>
				
				<label for="producto">Productos</label> 
				<select name="idProducto" id="producto">					
					<option value="${peticion.idProducto}" selected>${peticion.nombreProducto}</option>
					<c:forEach items="${comboProducto}" var="producto">
						<option value="${producto.id}">${producto.nombre}</option>
					</c:forEach>
				</select> 
				<br> <br>
				
				<label for="cantidad">Cantidad</label> 
				<input type="text" id="cantidad" name="cantidad" value="${peticion.cantidad}"> 
				<br>
				
				<label for="estadopedido">Estado Pedido</label> 
				<select name="estado" id="estadopedido">
					<option value="${peticion.idEstado}" selected>${peticion.nombreEstado}</option>
					<c:forEach items="${comboEstadoPedido}" var="estadopedido">
						<option value="${estadopedido.id}">${estadopedido.nombre}</option>
					</c:forEach>
				</select>
				<br>
				
				<label for="fecha">Fecha</label> <input type="text" value="${peticion.fecha}" name="fecha"> <br>
				
		 		<input type="submit" value="Modificar">
		 		</form>
		 	</div>
		 </c:forEach>
		 
		<c:if test ="${resultado == 1}">
		<p>Peticion actualizada</p>
		</c:if>
	</div>

</body>
</html>