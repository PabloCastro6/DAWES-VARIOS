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
<h2>Panel de control Tienda de componentes infarmaticos</h2>
</header>
<%@include file="/menu.html" %>

<div class="container">

		<h3>Listado Peticiones</h3>
		
		<div class="form">
			<form
				action="http://localhost:8080/tienda/peticiones/listarpeticiones" method="POST" id="formulario">

				<label for="id">Id Peticion:</label> 
				<br>
				<input type="text" id="idPeticiones" name="idPeticiones"> 
				<br>
				<label for="cliente">Cliente:</label>
				<br>
				<select name="idCliente" id="idCliente" form="formulario">
				
						<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
				
				</select>
				<br><br>
				<label for="producto">Producto:</label>
				<br>
				<select name="idProducto" id="idProducto" form="formulario">
						<option value="">Seleccione una opcion</option>
					<c:forEach items="${comboProducto}" var="producto">
						<option value="${producto.id}">${producto.nombre}</option>
					</c:forEach>
				
				</select>
				<br><br>
				<label for="cantidad" >Cantidad:</label>
				<br>
				<input type="text" id="cantidad" name="cantidad"> 
				<br><br>
				<label for="estado">Estado:</label>
				<br>
				<select name="estado" id="estado" form="formulario">
				
						<option value="">Seleccione una opcion</option>
						
					<c:forEach items="${comboEstadoPedido}" var="estadoPedido">
						<option value="${estadoPedido.id}">${estadoPedido.nombre}</option>
					</c:forEach>
				
				</select>
				<br><br>
				<label for="fecha">Fecha:</label> 
				<br>
				<input type="date" name="fecha" id="fecha">
				<br><br>
			 	<input type="submit" value="Enviar">
			</form>
		</div>
		<br><br>
	<c:if test="${not empty lista}">
		<table>
			<tr>
				<th>Id Peticion</th>
				<th>Cliente</th>
				<th>Producto</th>
				<th>Fecha Peticion</th>
			</tr>
			
			<c:forEach items="${lista}" var="peticiones">
				<tr>
					<td>${peticiones.iD}</td>
					<td>${peticiones.nombreCliente}</td>
					<td>${peticiones.nombreProducto}</td>
					<td>${peticiones.fecha}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		
</div>

</body>
</html>