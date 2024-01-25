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
<h2>PEDIDOS</h2>
</header>
<%@include file="../menu.html" %>


<div class="container">

		<h3>Listado Pedidos</h3>
		
		<div class="form">
			<form
				action="http://localhost:8080/tienda/pedidos/listarpedido" method="POST">

				<label for="id">Id Pedido:</label> 
				<br>
				<input type="text" id="id" name="id"> 
				<br>
				<label for="cliente">Cliente:</label>
				<br>
				<select name="idCliente" id="idCliente" >
						<option value="">Seleccione una opcion</option>
							<c:forEach items="${comboCliente}" var="cliente">
								<option value="${cliente.id}">${cliente.nombre}</option>
							</c:forEach>
				</select>
				<br><br>
				<label for="fecha">Fecha:</label> 
				<br>
				<input type="date" name="fecha" id="fecha">
				<br><br>
				<label for="estado">Estado:</label>
				<br>
				<select name="idEstado" id="idEstado" >
						<option value="">Seleccione una opcion</option>
							<c:forEach items="${comboEstadoPedido}" var="estado">
								<option value="${estado.id}">${estado.nombre}</option>
							</c:forEach>
				
				</select>
				<br><br>
				
			 	<input type="submit" value="Enviar">
			</form>
		</div>
		<br><br>
	<c:if test="${not empty lista}">
		<table>
			<tr>
				<th>ID</th>
				<th>Cliente</th>
				<th>Producto</th>
				<th>Cantidad</th>
				<th>Precio</th>
			</tr>
			
			<c:forEach items="${lista}" var="pedido">
				<tr>
					<td>${pedido.id}</td>
					<td>${pedido.nombreCliente}</td>
					<td>${pedido.nombreProducto}</td>
					<td>${pedido.cantidad}</td>
					<td>${pedido.precio}</td>
					

				</tr>
			</c:forEach>
		</table>
	</c:if>
		
</div>

</body>
</html>