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
<%@include file="/menu.html" %>

<div class="container">
		<h3>Modificacion Pedido</h3>
		
		<div class="form">
			<form action="http://localhost:8080/tienda/pedido/formularioactualizarpedido" method="POST" >
			
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
			 	<input type="submit" value="Buscar">
			</form>
		</div>

		
	<h3>Resultado de busqueda</h3>
	
	<c:forEach items="${lista}" var="pedido">
	
		<div class="form">
			<form action="http://localhost:8080/tienda/pedido/actualizarpedido" method="POST">
			
				<label for="id">Id Peticion:</label> 
				<br>
				<input type="text" id="id" name="id" value ="${pedido.id}" readonly> 
				<br>
				<label for="cliente">Cliente:</label>
				<br>
				<select name="idCliente" id="idCliente" >
					<c:forEach items="${comboCliente}" var="cliente">
						<option value="${cliente.id}">${cliente.nombre}</option>
					</c:forEach>
						<option value="${pedido.idCliente}" selected>${pedido.nombreCliente}</option>
				</select>
				<br><br>
				<label for="producto">Producto:</label>
				<br>
				<select name="idProducto" id="idProducto">
					<c:forEach items="${comboProducto}" var="producto">
						<option value="${producto.id}" >${producto.nombre}</option>
					</c:forEach>
						<option value="${pedido.idProducto}" selected>${pedido.nombreProducto}</option>
				</select>
				<br><br>
				<label for="cantidad" >Cantidad:</label>
				<br>
				<input type="text" id="cantidad" name="cantidad" value ="${pedido.cantidad}" selected> 
				<br><br>
				<label for="precio">Precio:</label>
				<br>
				<input type="text" name="precio" id="precio"  value ="${pedido.precio}" selected>
				<br><br>
			
			<input type="submit" value="Modificar">
			</form>
			
		</div>
	
			<br>
	</c:forEach>
		
		
</div> <!-- fin container -->

</body>
</html>